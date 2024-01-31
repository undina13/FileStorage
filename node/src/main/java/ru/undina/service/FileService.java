package ru.undina.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.undina.entity.AppDocument;
import ru.undina.entity.AppPhoto;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
}
