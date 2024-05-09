package co.newtonschool.splitwise.model;

public class User {
    private static int id = 1;
    private int userId;
    private String firstName;
    private String lastName;
    private String username;

    public User(String firstName, String lastName) {
        userId = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        setUsername();
    }

    public int getUserId() {
        return userId;
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

    private void setUsername() {
        int randomNumber = (int)((Math.random() + 1) * 10000);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(firstName.toLowerCase())
                .append("_")
                .append(lastName.toLowerCase())
                .append("_")
                .append(randomNumber);

        this.username = stringBuilder.toString();
    }

    public String getUsername() {
        return username;
    }
}