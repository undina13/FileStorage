package ru.undina.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import ru.undina.entity.AppDocument;

public interface FileService {
    AppDocument processDoc(Message externalMessage);
}
