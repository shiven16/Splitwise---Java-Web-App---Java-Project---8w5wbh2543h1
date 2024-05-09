
package co.newtonschool.splitwise.response;

import java.util.List;

public class UserExpenseDetail {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private List<ExpenseUserResponse> expenseUserResponseList;
    private float totalShare;

    public UserExpenseDetail(int id, String firstName, String lastName, String username, List<ExpenseUserResponse> expenseUserResponseList, float totalShare) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.expenseUserResponseList = expenseUserResponseList;
        this.totalShare = totalShare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<ExpenseUserResponse> getExpenseUserResponseList() {
        return expenseUserResponseList;
    }

    public void setExpenseUserResponseList(List<ExpenseUserResponse> expenseUserResponseList) {
        this.expenseUserResponseList = expenseUserResponseList;
    }

    public float getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(float totalShare) {
        this.totalShare = totalShare;
    }
}
