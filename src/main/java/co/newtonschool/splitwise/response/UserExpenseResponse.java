package co.newtonschool.splitwise.response;

public class UserExpenseResponse {
    private String username;
    private float share;

    public UserExpenseResponse(String username, float share) {
        this.username = username;
        this.share = share;
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
}