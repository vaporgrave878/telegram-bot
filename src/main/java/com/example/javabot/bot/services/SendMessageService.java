package com.example.javabot.bot.services;

import com.example.javabot.bot.messagesender.MessageSender;
import com.example.javabot.bot.models.User;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

@Service
public class SendMessageService {
    private final MessageSender messageSender;

    public SendMessageService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void test1(Message message){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        var keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add(KeyboardButton.builder()
                .text("Subscribe")
                .requestContact(true)
                .build());
        row1.add("Unsubscribe");
        row1.add("Test");
        keyboardRows.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Test Message!");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        messageSender.sendMessage(sendMessage);
    }

    public void test2(Message message){
        var ms1 = SendMessage.builder()
                .text("<b>Bold</b> " +
                        "<i>italic</i>" +
                        " <code>mono</code> " +
                        "<a href=\"google.com\">Google</a>")
                .chatId(String.valueOf(message.getChatId()))
                .parseMode("HTML")
                .build();

        messageSender.sendMessage(ms1);
    }

    public void successSubscribe(Message message){
        var sucSub = SendMessage.builder()
                .text("<b> Ви успішно зараєстровані:)! </b>")
                .chatId(String.valueOf(message.getChatId()))
                .parseMode("HTML")
                .build();
        messageSender.sendMessage(sucSub);
    }
     public void subTest(Message message){
        User user = new User();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Ви вже зареєстровані!, " + user.getUsername());
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        messageSender.sendMessage(sendMessage);
     }

     public void registration(Message message){
            var sendMessage = SendMessage.builder()
                    .text("Тепер введіть своє ім'я!")
                    .chatId(String.valueOf(message.getChatId()))
                    .build();
            messageSender.sendMessage(sendMessage);
            String text = message.getText();
     }

}
