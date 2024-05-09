package co.newtonschool.splitwise.controller;

import co.newtonschool.splitwise.request.ExpenseRequest;
import co.newtonschool.splitwise.response.*;
import co.newtonschool.splitwise.service.ExpenseService;
import co.newtonschool.splitwise.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static co.newtonschool.splitwise.SplitwiseApplication.getExpenseService;
import static co.newtonschool.splitwise.SplitwiseApplication.getUserService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private ExpenseService expenseService;
    private UserService userService;

    @PostConstruct
    void init() {
        expenseService = getExpenseService();
        userService = getUserService();
    }

    @GetMapping("")
    public ModelAndView readExpenses() {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = expenseService.readExpenses();

        ExpenseResponseList expenseResponseList = (ExpenseResponseList) responseEntity.getBody();
        List<ExpenseResponse> expenseResponses = expenseResponseList.getExpenseResponseList();

        modelAndView.addObject("expenseList", expenseResponses);
        modelAndView.setViewName("expense-list");

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addExpense() {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = userService.readUsers();

        UserResponseList userResponseList = (UserResponseList) responseEntity.getBody();
        List<UserResponse> userResponses = userResponseList.getUserResponseList();

        modelAndView.addObject("userList", userResponses);
        modelAndView.setViewName("add-expense");

        return modelAndView;
    }

    @PostMapping("")
    public ResponseEntity<?> createExpenseAndUserExpense(@RequestBody ExpenseRequest expenseRequest) {
        return expenseService.createExpenseAndUserExpense(expenseRequest);
    }

    @GetMapping("{expenseId}")
    public ModelAndView readExpenseById(@PathVariable("expenseId") int expenseId) {
        ModelAndView modelAndView = new ModelAndView();
        ResponseEntity<?> responseEntity = expenseService.readExpenseById(expenseId);

        ExpenseUserDetail expenseUserDetail = (ExpenseUserDetail) responseEntity.getBody();

        modelAndView.addObject("expenseDetails", expenseUserDetail);
        modelAndView.setViewName("expense");

        return modelAndView;
    }
}