package co.newtonschool.splitwise.service;

import co.newtonschool.splitwise.request.ExpenseRequest;
import org.springframework.http.ResponseEntity;

public interface ExpenseService {
    ResponseEntity<?> createExpenseAndUserExpense(ExpenseRequest expenseRequest);

    ResponseEntity<?> readExpenses();

    ResponseEntity<?> readExpenseById(int expenseId);
}
