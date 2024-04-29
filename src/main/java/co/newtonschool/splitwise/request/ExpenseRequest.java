package co.newtonschool.splitwise.request;

import java.util.List;

public class ExpenseRequest {
    private String expenseTitle;
    private float expenseAmount;
    private String splitType;
    private List<SplitDetail> splitDetailList;

    public String getExpenseTitle() {
        return expenseTitle;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getSplitType() {
        return splitType;
    }

    public void setSplitType(String splitType) {
        this.splitType = splitType;
    }

    public List<SplitDetail> getSplitDetailList() {
        return splitDetailList;
    }

    public void setSplitDetailList(List<SplitDetail> splitDetailList) {
        this.splitDetailList = splitDetailList;
    }
}
