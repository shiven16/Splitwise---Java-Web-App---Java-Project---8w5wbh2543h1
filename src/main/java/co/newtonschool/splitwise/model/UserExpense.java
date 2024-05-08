package co.newtonschool.splitwise.model;

public class UserExpense{
     private User user;
     private Expense expense;
     private float share;
     private int userExpenseId;
     
     public UserExpense(User user, Expense expense, float share) {
          this.user = user;
          this.share = share;
     }
     
     public User getUser() {
          return user;
     }
     
     public void setUser(User user) {
          this.user = user;
     }
     
     public float getShare() {
          return share;
     }
     
     public void setShare(float share) {
          this.share = share;
     }

     public Expense getExpense() {
          return expense;
     }

     public int getUserExpenseId() {
          return userExpenseId;
     }
}