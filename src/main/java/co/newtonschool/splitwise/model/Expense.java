package co.newtonschool.splitwise.model;

import java.time.LocalDateTime;

public class Expense {
    public enum SplitType {
        EACH,
        PERCENTAGE,
        SHARE
    }

    private static int id = 1;
    private int expenseId;
    private String expenseTitle;
    private float expenseAmount;
    private SplitType splitType;
    private LocalDateTime expenseDateTime;

    public Expense(String expenseTitle, float expenseAmount, SplitType splitType, LocalDateTime expenseDateTime) {
        expenseId = id++;
        this.expenseTitle = expenseTitle;
        this.expenseAmount = expenseAmount;
        this.splitType = splitType;
        this.expenseDateTime = expenseDateTime;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public LocalDateTime getExpenseDateTime() {
        return expenseDateTime;
    }
}