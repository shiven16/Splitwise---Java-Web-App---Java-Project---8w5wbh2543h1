
package co.newtonschool.splitwise.response;

public class GenericResponse {
    private String message;

    public GenericResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
