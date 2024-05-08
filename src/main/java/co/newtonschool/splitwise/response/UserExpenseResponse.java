package co.newtonschool.splitwise.response;

public class UserExpenseResponse {
     private String username;
     private float share;
     
     public UserExpenseResponse(String username, float share) {
          this.username = username;
          this.share = share;
     }
     
}