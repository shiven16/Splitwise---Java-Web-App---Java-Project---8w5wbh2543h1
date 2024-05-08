package co.newtonschool.splitwise.response;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ExpenseUserDetail {
     private int expenseId;
     private String expenseTitle;
     private float expenseAmount;
     private String splitType;
     private LocalDate createdAt;
     private LocalTime createdTime;
     private List<UserExpenseResponse> userExpenseResponse;
     
     public ExpenseUserDetail(int expenseId,String expenseTitle, float expenseAmount, String splitType, LocalDate createdAt, LocalTime createdTime, List<UserExpenseResponse> userExpenseResponses) {
          this.expenseId = expenseId;
          this.expenseTitle = expenseTitle;
          this.expenseAmount = expenseAmount;
          this.splitType = splitType;
          this.createdAt = createdAt;
          this.createdTime = createdTime;
          this.userExpenseResponse = userExpenseResponse;
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
     
     public String getSplitType() {
          return splitType;
     }
     
     public void setSplitType(String splitType) {
          this.splitType = splitType;
     }
     
     public LocalDate getCreatedAt() {
          return createdAt;
     }
     
     public void setCreatedAt(LocalDate createdAt) {
          this.createdAt = createdAt;
     }
     
     public LocalTime getCreatedTime() {
          return createdTime;
     }
     
     public void setCreatedTime(LocalTime createdTime) {
          this.createdTime = createdTime;
     }
     

}