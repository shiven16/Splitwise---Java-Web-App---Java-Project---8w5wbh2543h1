package co.newtonschool.splitwise.response;

import java.util.List;

public class UserExpenseDetail {
     private int userId;
     private String firstName;
     private String lastName;
     private String username;
     private float share;
     private List<ExpenseUserResponse> expenseUserResponseList;
     
     public UserExpenseDetail(int userId, String firstName, String lastName, String username, List<ExpenseUserResponse> expenseUserResponseList, float share) {
          this.userId = userId;
          this.firstName = firstName;
          this.lastName = lastName;
          this.username = username;
          this.expenseUserResponseList = expenseUserResponseList;
          this.share = share;
     }
     
     public int getUserId() {
          return userId;
     }
     
     public void setUserId(int userId) {
          this.userId = userId;
     }
     
     public String getFirstName() {
          return firstName;
     }
     
     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }
     
     public String getLastName() {
          return lastName;
     }
     
     public void setLastName(String lastName) {
          this.lastName = lastName;
     }
     
     public String getUsername() {
          return username;
     }
     
     public void setUsername(String username) {
          this.username = username;
     }

     public float getShare() {
          return share;
     }

     public void setShare(float share) {
          this.share = share;
     }

     public List<ExpenseUserResponse> getExpenseUserResponseList() {
          return expenseUserResponseList;
     }
}