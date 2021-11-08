package com.example.javabot.bot.repo;

import com.example.javabot.bot.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
