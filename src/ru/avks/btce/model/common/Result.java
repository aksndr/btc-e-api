package ru.avks.btce.model.common;


public class Result {

    private int success;

    private String error;

    public int getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public void setError(String error) {
        this.error = error;
    }
}
