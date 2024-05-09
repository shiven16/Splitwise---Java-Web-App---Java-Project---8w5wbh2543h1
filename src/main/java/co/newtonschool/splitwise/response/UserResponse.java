package co.newtonschool.splitwise.response;

import java.util.List;

public class UserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String username;

    public UserResponse(int id, String firstName, String lastName, String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }
}