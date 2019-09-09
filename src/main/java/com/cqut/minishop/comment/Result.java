package com.cqut.minishop.comment;

public class Result {

    /**
     * 返回码
     */
    private int code;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 数据
     */
    private Object data;

    public Result(){

    }

    public Result(boolean isSuccess, String errorMessage){
        if(isSuccess){
            code = Constants.GLOBAL_NORMAL_STATUS_INT;
            this.errorMessage = null;
        }else{
            code = Constants.GLOBAL_ERROR_STATUS_INT;
            this.errorMessage = errorMessage;
        }
    }

    public Result(boolean isSuccess, String errorMessage, Object data){
        if(isSuccess){
            code = Constants.GLOBAL_NORMAL_STATUS_INT;
            this.errorMessage = null;
            this.data = data;
        }else{
            code = Constants.GLOBAL_ERROR_STATUS_INT;
            this.errorMessage = errorMessage;
            this.data = null;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}