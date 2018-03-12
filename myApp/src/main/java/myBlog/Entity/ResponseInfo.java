package myBlog.Entity;

import java.io.Serializable;

public class ResponseInfo implements Serializable {

    private String message;

    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.code = responseCode.code;
        this.message = responseCode.message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
