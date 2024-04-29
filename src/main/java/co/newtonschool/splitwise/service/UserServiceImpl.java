package co.newtonschool.splitwise.service;

import co.newtonschool.splitwise.model.User;
import co.newtonschool.splitwise.model.UserExpense;
import co.newtonschool.splitwise.repository.UserExpenseRepository;
import co.newtonschool.splitwise.repository.UserRepository;
import co.newtonschool.splitwise.request.UserRequest;
import co.newtonschool.splitwise.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static co.newtonschool.splitwise.SplitwiseApplication.getUserExpenseRepository;
import static co.newtonschool.splitwise.SplitwiseApplication.getUserRepository;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;

    public UserServiceImpl() {
        userRepository = getUserRepository();
        userExpenseRepository = getUserExpenseRepository();
    }

    public ResponseEntity<?> readUsers() {
        List<User> userList = userRepository.getAllUsers();

        List<UserResponse> userResponseList = new ArrayList<>();
        for(User user : userList) {
            UserResponse userResponse = new UserResponse(
                    user.getUserId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername()
            );

            userResponseList.add(userResponse);
        }

        UserResponseList users = new UserResponseList(userResponseList);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<?> createUsers(UserRequest userRequest) {
        User user = new User(
                userRequest.getFirstName(),
                userRequest.getLastName()
        );

        userRepository.saveUser(user);

        return ResponseEntity.ok(new GenericResponse("User Added Successfully"));
    }

    public ResponseEntity<?> readUserById(int userId) {
        User user = userRepository.getUserById(userId);
        List<UserExpense> userExpenseList = userExpenseRepository.getUserExpenseListByUserId(userId);

        List<ExpenseUserResponse> expenseUserResponseList = new ArrayList<>();
        float totalShare = 0.0f;
        for(UserExpense userExpense : userExpenseList) {
            ExpenseUserResponse expenseUserResponse
                    = new ExpenseUserResponse(
                    userExpense.getExpense().getExpenseTitle(),
                    userExpense.getExpense().getExpenseAmount(),
                    userExpense.getShare()
            );
            expenseUserResponseList.add(expenseUserResponse);
            totalShare += userExpense.getShare();
        }

        UserExpenseDetail userExpenseDetail = new UserExpenseDetail(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                expenseUserResponseList,
                totalShare
        );

        return ResponseEntity.ok(userExpenseDetail);
    }
}
