package co.newtonschool.splitwise.repository;

import co.newtonschool.splitwise.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private final Map<Integer, User> userMapById = new HashMap<>();

    public User saveUser(User user) {
        userMapById.put(user.getUserId(), user);

        return user;
    }

    public List<User> saveAllUsers(List<User> userList) {
        for(User user : userList) {
            saveUser(user);
        }

        return userList;
    }

    public User getUserById(int id) {
        return userMapById.get(id);
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        for(Map.Entry<Integer, User> entry : userMapById.entrySet()) {
            userList.add(entry.getValue());
        }

        return userList;
    }

    public Map<Integer, User> getUserMapById() {
        return userMapById;
    }
}
