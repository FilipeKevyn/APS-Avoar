package controller;

import models.User;
import repositories.UserRepository;

public class UserController {
    private UserRepository repository;
    private User currentUser;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public String viewHistory(String nome){
        User user = repository.findByUsername(nome);
        return user.viewHistory();
    }

    public boolean login(String username, String password) {
        User user = repository.findByUsername(username);
        currentUser = user;
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(String name, String email, String password) {
        if (repository.existsByEmail(email)) {
            return false;
        }
        repository.save(new User(name, email, password));
        return true;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void logout(){
        currentUser = null;
    }
}
