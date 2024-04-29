package co.newtonschool.splitwise.response;

public class ExpenseUserResponse {
    private String expenseTitle;
    private float expenseAmount;
    private float share;

    public ExpenseUserResponse(String expenseTitle, float expenseAmount, float share) {
        this.expenseTitle = expenseTitle;
        this.expenseAmount = expenseAmount;
        this.share = share;
    }

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

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }
}
