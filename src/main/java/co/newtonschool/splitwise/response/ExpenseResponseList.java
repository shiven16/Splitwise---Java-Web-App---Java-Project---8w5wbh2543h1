package co.newtonschool.splitwise.response;

import java.util.List;

public class ExpenseResponseList {
     private List<ExpenseResponse> expenseResponses;
     
     public ExpenseResponseList(List<ExpenseResponse> expenseResponses) {
          this.expenseResponses = expenseResponses;
     }
     
     public List<ExpenseResponse> getExpenseResponseList() {
          return expenseResponses;
     }
     
     public void setExpenseResponses(List<ExpenseResponse> expenseResponses) {
          this.expenseResponses = expenseResponses;
     }
}
