package com.example.javabot.bot;

import com.example.javabot.bot.messagesender.MessageSender;
import com.example.javabot.bot.models.User;
import com.example.javabot.bot.repo.UserRepository;
import com.example.javabot.bot.services.SendMessageService;
import com.example.javabot.bot.services.Subscribtions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;


import java.util.Optional;

@Component
public class StopGameBot extends TelegramLongPollingBot {
    @Value("${telegram.bot.username}")
    private String username;
    @Value("${telegram.bot.token}")
    private String token;

    private SendMessageService sendMessageService;
    private Subscribtions subscribtions;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            if(message.getText().equals("/start")){
                sendMessageService.test1(message);
            }
            if(message.getText().equals("/subscribe")){
                subscribtions.subscribe(message);

            }
        }
    }

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Autowired
    public void setSubscribtions(Subscribtions subscribtions) {
        this.subscribtions = subscribtions;
    }
}
