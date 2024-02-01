package ru.undina.service;

import ru.undina.dto.MailParams;

public interface MailSenderService {
    void send(MailParams mailParams);
}
