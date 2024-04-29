package co.newtonschool.splitwise.request;

public class SplitDetail {
    private Integer userId;
    private Float split;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getSplit() {
        return split;
    }

    public void setSplit(Float split) {
        this.split = split;
    }
}
