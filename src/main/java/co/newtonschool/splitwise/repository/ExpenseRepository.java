package co.newtonschool.splitwise.repository;

import co.newtonschool.splitwise.model.Expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    private final Map<Integer, Expense> expenseMapById = new HashMap<>();

    public Expense saveExpense(Expense expense) {
        expenseMapById.put(expense.getExpenseId(), expense);

        return expense;
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenseList = new ArrayList<>();
        for(Map.Entry<Integer, Expense> entry : expenseMapById.entrySet()) {
            expenseList.add(entry.getValue());
        }

        return expenseList;
    }

    public Expense getExpenseById(int id) {
        return expenseMapById.get(id);
    }
}
