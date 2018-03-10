package myBlog.Entity;

import java.io.Serializable;

public class ResponseInfo implements Serializable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
