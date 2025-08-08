package repositories;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users = new ArrayList<>();

    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }

    public void save(User user) {
        users.add(user);
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(u -> u.getName().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<User> findAll() {
        return users;
    }
}
