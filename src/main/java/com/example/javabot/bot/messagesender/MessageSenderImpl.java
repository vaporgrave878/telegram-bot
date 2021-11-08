package com.example.javabot.bot.messagesender;

import com.example.javabot.bot.StopGameBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private StopGameBot stopGameBot;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            stopGameBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendEditMessage(EditMessageText editMessageText) {
        try {
            stopGameBot.execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setStopGameBot(StopGameBot stopGameBot) {
        this.stopGameBot = stopGameBot;
    }
}
