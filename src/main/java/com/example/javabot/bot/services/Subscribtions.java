package com.example.javabot.bot.services;

import com.example.javabot.bot.messagesender.MessageSender;
import com.example.javabot.bot.models.User;
import com.example.javabot.bot.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Subscribtions {

    private SendMessageService sendMessageService;

    public Subscribtions() {
    }


    @Autowired
    private UserRepository userRepository;

    public User subscribe(Message message){
        User botUser = new User();
        botUser.setId(message.getChatId());
        botUser.setStatus(true);
        if(!userRepository.existsById(botUser.getId())){
            String text = message.getText();
            message.setText(text);
            sendMessageService.registration(message);
            botUser.setUsername(text);
            userRepository.save(botUser);

        }
        else {
            sendMessageService.subTest(message);
        }
        return botUser;
    }


    public void unsubscribe(int userId, boolean status){

    }
    public boolean isSubscribed(Message message){
        return userRepository.existsById(message.getChatId());
    }

    @Autowired
    public void setSendMessageService(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
}
