package co.newtonschool.splitwise.service;

import co.newtonschool.splitwise.model.Expense;
import co.newtonschool.splitwise.model.User;
import co.newtonschool.splitwise.model.UserExpense;
import co.newtonschool.splitwise.repository.ExpenseRepository;
import co.newtonschool.splitwise.repository.UserExpenseRepository;
import co.newtonschool.splitwise.repository.UserRepository;
import co.newtonschool.splitwise.request.ExpenseRequest;
import co.newtonschool.splitwise.request.SplitDetail;
import co.newtonschool.splitwise.response.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static co.newtonschool.splitwise.SplitwiseApplication.*;

public class ExpenseServiceImpl implements ExpenseService {
    private ExpenseRepository expenseRepository;
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;

    public ExpenseServiceImpl() {
        expenseRepository = getExpenseRepository();
        userRepository = getUserRepository();
        userExpenseRepository = getUserExpenseRepository();
    }

    public ResponseEntity<?> createExpenseAndUserExpense(ExpenseRequest expenseRequest) {
        boolean isValid = validateExpense(expenseRequest);

        if(!isValid) {
            return new ResponseEntity<>(new GenericResponse("Percentages do not add to 100"), HttpStatus.BAD_REQUEST);
        }

        Expense expense = createExpense(expenseRequest);

        return createUserExpense(expenseRequest, expense);
    }

    private boolean validateExpense(ExpenseRequest expenseRequest) {
        float total = getTotal(expenseRequest);

        if(expenseRequest.getSplitType().equals("PERCENTAGE") && total != 100.0f) {
            return false;
        }

        return true;
    }

    private Expense createExpense(ExpenseRequest expenseRequest) {
        Expense expense = new Expense(
                expenseRequest.getExpenseTitle(),
                expenseRequest.getExpenseAmount(),
                Expense.SplitType.valueOf(expenseRequest.getSplitType()),
                LocalDateTime.now()
        );

        return expenseRepository.saveExpense(expense);
    }

    private ResponseEntity<?> createUserExpense(ExpenseRequest expenseRequest, Expense expense) {
        List<SplitDetail> splitDetailList = expenseRequest.getSplitDetailList();

        float total = getTotal(expenseRequest);

        float expenseAmount = expenseRequest.getExpenseAmount();
        List<UserExpense> userExpenseList = new ArrayList<>();
        for(SplitDetail splitDetail : splitDetailList) {
            User user = userRepository.getUserById(splitDetail.getUserId());
            float share = (splitDetail.getSplit() / total) * expenseAmount;

            UserExpense userExpense = new UserExpense(user, expense, share);
            userExpenseList.add(userExpense);
        }

        userExpenseRepository.saveAllUserExpense(userExpenseList);

        return ResponseEntity.ok(new GenericResponse("Expense Added Successfully"));
    }

    private float getTotal(ExpenseRequest expenseRequest) {
        List<SplitDetail> splitDetailList = expenseRequest.getSplitDetailList();

        float total = 0.0f;
        if(expenseRequest.getSplitType().equals("EACH")) {
            total = splitDetailList.size();
        }
        else {
            for(SplitDetail splitDetail : splitDetailList) {
                total += splitDetail.getSplit();
            }
        }

        return total;
    }

    public ResponseEntity<?> readExpenses() {
        List<Expense> expenseList = expenseRepository.getAllExpenses();

        List<ExpenseResponse> expenseResponseList = new ArrayList<>();
        for(Expense expense : expenseList) {
            ExpenseResponse expenseResponse = new ExpenseResponse(
                    expense.getExpenseId(),
                    expense.getExpenseTitle(),
                    expense.getExpenseAmount(),
                    expense.getSplitType().name(),
                    expense.getExpenseDateTime().toLocalDate(),
                    expense.getExpenseDateTime().toLocalTime()
            );

            expenseResponseList.add(expenseResponse);
        }

        ExpenseResponseList expenses = new ExpenseResponseList(expenseResponseList);

        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    public ResponseEntity<?> readExpenseById(int expenseId) {
        Expense expense = expenseRepository.getExpenseById(expenseId);
        List<UserExpense> userExpenseList = userExpenseRepository.getUserExpenseListByExpenseId(expenseId);

        List<UserExpenseResponse> userExpenseResponseList = new ArrayList<>();
        for(UserExpense userExpense : userExpenseList) {
            UserExpenseResponse userExpenseResponse
                    = new UserExpenseResponse(
                            userExpense.getUser().getUsername(),
                    userExpense.getShare()
            );
            userExpenseResponseList.add(userExpenseResponse);
        }

        ExpenseUserDetail expenseUserDetail = new ExpenseUserDetail(
                expense.getExpenseId(),
                expense.getExpenseTitle(),
                expense.getExpenseAmount(),
                expense.getSplitType().name(),
                expense.getExpenseDateTime().toLocalDate(),
                expense.getExpenseDateTime().toLocalTime(),
                userExpenseResponseList
        );

        return ResponseEntity.ok(expenseUserDetail);
    }
}
