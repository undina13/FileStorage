package ru.undina.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.undina.entity.AppDocument;
import ru.undina.entity.AppPhoto;
import ru.undina.service.enums.LinkType;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);

    String generateLink(Long docId, LinkType linkType);
}
