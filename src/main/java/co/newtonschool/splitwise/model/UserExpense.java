package co.newtonschool.splitwise.model;

public class UserExpense {
    private static int id = 1;
    private int userExpenseId;
    private User user;
    private Expense expense;
    private float share;

    public UserExpense(User user, Expense expense, float share) {
        userExpenseId = id++;
        this.user = user;
        this.expense = expense;
        this.share = share;
    }

    public int getUserExpenseId() {
        return userExpenseId;
    }

    public void setUserExpenseId(int userExpenseId) {
        this.userExpenseId = userExpenseId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public float getShare() {
        return share;
    }

    public void setShare(float share) {
        this.share = share;
    }

    @Override
    public String toString() {
        return "UserExpense{" +
                "userExpenseId=" + userExpenseId +
                ", user=" + user +
                ", expense=" + expense +
                ", share=" + share +
                '}';
    }
}