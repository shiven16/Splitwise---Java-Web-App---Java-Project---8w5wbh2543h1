package co.newtonschool.splitwise.response;

import co.newtonschool.splitwise.model.UserExpense;

import java.security.PublicKey;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ExpenseResponse {
     private int expenseId;
     private String expenseTitle;
     private float expenseAmount;
     private String splitType;
     private LocalDate createdAt;
     private LocalTime createdTime;
     private List<UserExpense> userExpenses;
     
     public ExpenseResponse(int expenseId,String expenseTitle, float expenseAmount, String splitType, LocalDate createdAt, LocalTime createdTime, List<UserExpense> userExpenses) {
          this.expenseId = expenseId;
          this.expenseTitle = expenseTitle;
          this.expenseAmount = expenseAmount;
          this.splitType = splitType;
          this.createdAt = createdAt;
          this.createdTime = createdTime;
          this.userExpenses = userExpenses;
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
     
     public List<UserExpense> getUserExpenses() {
          return userExpenses;
     }
     
     public void setUserExpenses(List<UserExpense> userExpenses) {
          this.userExpenses = userExpenses;
     }

}