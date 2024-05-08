package co.newtonschool.splitwise.model;

import java.time.LocalDateTime;

public class Expense {
    private String expenseTitle;
    private float expenseAmount;
    private SplitType splitType;
    private LocalDateTime createdAt;
    private int expenseId;

    public Expense(String expenseTitle, float expenseAmount, SplitType splitType, LocalDateTime createdAt) {
        this.expenseTitle = expenseTitle;
        this.expenseAmount = expenseAmount;
        this.splitType = splitType;
        this.createdAt = createdAt;
    }

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public LocalDateTime getExpenseDateTime() {
        return createdAt;
    }
    public enum SplitType {
        EQUAL, PERCENTAGE, EXACT
    }

}
