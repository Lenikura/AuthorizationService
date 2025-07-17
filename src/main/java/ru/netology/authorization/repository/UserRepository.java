package ru.netology.authorization.repository;

import ru.netology.authorization.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    private final Map<String, String> users = new HashMap<>();
    private final Map<String, List<Authorities>> permissions = new HashMap<>();

    public UserRepository() {
        users.put("admin", "admin123");
        permissions.put("admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE));

        users.put("user", "user123");
        permissions.put("user", List.of(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return permissions.get(user);
        }
        return Collections.emptyList();
    }
}