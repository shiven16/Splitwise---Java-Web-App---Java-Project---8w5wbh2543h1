package co.newtonschool.splitwise.response;


public class UserResponse {
     private int userId;
     private String firstName;
     private String lastName;
     private String username;
     
     public UserResponse(int userId, String firstName, String lastName, String username) {
          this.userId = userId;
          this.firstName = firstName;
          this.lastName = lastName;
          this.username = username;
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
}