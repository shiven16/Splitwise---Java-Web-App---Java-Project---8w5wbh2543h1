package co.newtonschool.splitwise.service;

import co.newtonschool.splitwise.request.UserRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> readUsers();
    ResponseEntity<?> createUsers(UserRequest userRequest);
    ResponseEntity<?> readUserById(int userId);
}
