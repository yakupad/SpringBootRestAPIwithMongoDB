package hello.helpers;

public class Response {
    private boolean isSuccess;
    private String message;
    private int errorCode;
    private Exception exception;

    public Response(){
    }

    public Response(boolean isSuccess, String message, int errorCode, Exception exception) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.errorCode = errorCode;
        this.exception = exception;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}