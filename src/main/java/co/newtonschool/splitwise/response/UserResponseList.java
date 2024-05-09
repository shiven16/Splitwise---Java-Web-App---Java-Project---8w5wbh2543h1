package co.newtonschool.splitwise.response;

import java.util.List;

public class UserResponseList {
    private List<UserResponse> userResponseList;

    public UserResponseList(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
    }

    public List<UserResponse> getUserResponseList() {
        return userResponseList;
    }

    public void setUserResponseList(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
    }
}