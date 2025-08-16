package controller;

import models.Ticket;
import models.User;
import repositories.UserRepository;

public class UserController {
    private UserRepository repository;
    private models.User currentUser;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    public boolean login(String username, String password) {
        models.User user = repository.findByUsername(username);
        currentUser = user;
        return user != null && user.getPassword().equals(password);
    }

    public boolean register(String name, String email, String password) {
        if (repository.existsByEmail(email)) {
            return false;
        }
        repository.save(new models.User(name, email, password));
        return true;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void logout(){
        currentUser = null;
    }

    public void cancelTicket(User user, Ticket ticket){
        user.cancelTicket(ticket);
    }

    public void cancelAllTicket(User user){
        user.cancelAllTickets();
    }
}
