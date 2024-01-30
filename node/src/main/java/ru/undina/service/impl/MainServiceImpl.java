package ru.undina.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import ru.undina.dao.AppUserDAO;
import ru.undina.dao.RawDataDAO;
import ru.undina.entity.AppUser;
import ru.undina.entity.RawData;
import ru.undina.service.MainService;
import ru.undina.service.ProducerService;

import static ru.undina.entity.enums.UserState.BASIC_STATE;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final RawDataDAO rawDataDAO;
    private final ProducerService producerService;
    private final AppUserDAO appUserDAO;

    @Override
    public void processTextMessage(Update update) {
        saveRawData(update);

        Message textMessage = update.getMessage();
        User telegramUser = textMessage.getFrom();
        AppUser appUser = findOrSaveAppUser(telegramUser);

        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText("Hello from NODE");
        producerService.producerAnswer(sendMessage);
    }

    private void saveRawData(Update update) {
        RawData rawData = RawData.builder()
                .event(update)
                .build();
        rawDataDAO.save(rawData);
    }

    private AppUser findOrSaveAppUser(User telegramUser) {
        AppUser persistentAppUser = appUserDAO.findAppUserByTelegramUserId(telegramUser.getId());
        if (persistentAppUser == null) {
            AppUser transientAppUser = AppUser.builder()
                    .telegramUserId(telegramUser.getId())
                    .username(telegramUser.getUserName())
                    .firstName(telegramUser.getFirstName())
                    .lastName(telegramUser.getLastName())
                    //TODO изменить значение по умолчанию после добавления регистрации
                    .isActive(true)
                    .state(BASIC_STATE)
                    .build();
            return appUserDAO.save(transientAppUser);
        }
        return persistentAppUser;
    }

}
