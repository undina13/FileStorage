package ru.undina.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.undina.service.ProducerService;

import static ru.undina.model.RabbitQueue.ANSWER_MESSAGE;

@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {
    private final RabbitTemplate rabbitTemplate;

    @Override
    public void producerAnswer(SendMessage sendMessage) {
        rabbitTemplate.convertAndSend(ANSWER_MESSAGE, sendMessage);
    }
}
