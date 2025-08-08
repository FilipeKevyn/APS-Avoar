package controller;

import models.User;
import repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginController {
    private UserRepository userRepo;

    public LoginController(UserRepository repo) {
        this.userRepo = repo;
    }

    public boolean login(String username, String password) {
        User user = userRepo.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(String name, String email, String password) {
        if (userRepo.existsByEmail(email)) {
            return false;
        }
        userRepo.save(new User(name, email, password));
        return true;
    }
}