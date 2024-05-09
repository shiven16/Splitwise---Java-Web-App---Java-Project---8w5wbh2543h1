package co.newtonschool.splitwise.response;

import java.util.List;

public class ExpenseResponseList {
    private List<ExpenseResponse> expenseResponseList;

    public ExpenseResponseList(List<ExpenseResponse> expenseResponseList) {
        this.expenseResponseList = expenseResponseList;
    }

    public List<ExpenseResponse> getExpenseResponseList() {
        return expenseResponseList;
    }

    public void setExpenseResponseList(List<ExpenseResponse> expenseResponseList) {
        this.expenseResponseList = expenseResponseList;
    }
}