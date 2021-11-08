package com.example.javabot.bot.models;

import org.telegram.telegrambots.meta.api.objects.Contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Entity
public class User implements Serializable {

    @Id
    /*@GeneratedValue(strategy = GenerationType.AUTO)*/
    private Long id;
    private String username;
    private boolean status;

    public User(){}

    public User(String username, boolean status){
        this.username = username;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User city = (User) o;
        return userId == city.userId &&
                Objects.equals(status, city.status);
    }*/
}
