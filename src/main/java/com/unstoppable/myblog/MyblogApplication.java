package com.unstoppable.myblog;

import com.unstoppable.myblog.entity.User;
import com.unstoppable.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyblogApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User newAdmin = new User("admin@gmail.com", "Admin", "123");
        userService.createAdmin(newAdmin);
    }
}
