package co.newtonschool.splitwise.repository;

import co.newtonschool.splitwise.model.UserExpense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserExpenseRepository {
    private final Map<Integer, UserExpense> userExpenseByIdMap = new HashMap<>();

    public UserExpense saveUserExpense(UserExpense userExpense) {
        userExpenseByIdMap.put(userExpense.getUserExpenseId(), userExpense);

        return userExpense;
    }

    public List<UserExpense> saveAllUserExpense(List<UserExpense> userExpenseList) {
        for(UserExpense userExpense : userExpenseList) {
            saveUserExpense(userExpense);
        }

        return userExpenseList;
    }

    public List<UserExpense> getUserExpenseListByExpenseId(int expenseId) {
        List<UserExpense> userExpenseList = new ArrayList<>();

        for(Map.Entry<Integer, UserExpense> entry : userExpenseByIdMap.entrySet()) {
            UserExpense userExpense = entry.getValue();

            if(userExpense.getExpense().getExpenseId() == expenseId) {
                userExpenseList.add(userExpense);
            }
        }

        return userExpenseList;
    }

    public List<UserExpense> getUserExpenseListByUserId(int userId) {
        List<UserExpense> userExpenseList = new ArrayList<>();

        for(Map.Entry<Integer, UserExpense> entry : userExpenseByIdMap.entrySet()) {
            UserExpense userExpense = entry.getValue();

            if(userExpense.getUser().getUserId() == userId) {
                userExpenseList.add(userExpense);
            }
        }

        return userExpenseList;
    }
}
