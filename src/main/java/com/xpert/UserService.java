package com.xpert;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public Optional<User> getUser(Long id) {
        return repo.findById(id);
    }

    public User updateUser(Long id, String name, String email) {

        return repo.findById(id).map(user -> {

            user.setName(name);
            user.setEmail(email);

            return repo.save(user);

        }).orElseThrow(() ->
            new RuntimeException("User not Found")
        );
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

    public List<User> listUsers() {
        return repo.findAll();
    }
}