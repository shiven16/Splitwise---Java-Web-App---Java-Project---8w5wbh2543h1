package co.newtonschool.splitwise.controller;

import co.newtonschool.splitwise.request.UserRequest;
import co.newtonschool.splitwise.response.UserExpenseDetail;
import co.newtonschool.splitwise.response.UserResponse;
import co.newtonschool.splitwise.response.UserResponseList;
import co.newtonschool.splitwise.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static co.newtonschool.splitwise.SplitwiseApplication.getUserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @PostConstruct
    void init() {
        userService = getUserService();
    }

    @GetMapping("")
    public ModelAndView readUsers() {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = userService.readUsers();

        UserResponseList userResponseList = (UserResponseList) responseEntity.getBody();
        List<UserResponse> userResponses = userResponseList.getUserResponseList();

        modelAndView.addObject("userList", userResponses);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("create-user");

        return modelAndView;
    }

    @PostMapping("")
    public ModelAndView createUsers(UserRequest userRequest) {
        userService.createUsers(userRequest);

        return new ModelAndView("redirect:" + "/users");
    }

    @GetMapping("/{userId}")
    public ModelAndView readUserById(@PathVariable("userId") int userId) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = userService.readUserById(userId);

        UserExpenseDetail userExpenseDetail = (UserExpenseDetail) responseEntity.getBody();

        modelAndView.addObject("userDetails", userExpenseDetail);
        modelAndView.setViewName("user");

        return modelAndView;
    }
}