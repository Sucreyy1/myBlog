package myBlog.Entity;

import java.io.Serializable;

/**
 * 返回给前端的信息
 * 如需扩展自定义的返回信息,可以继承此类进行扩展
 */
public class ResponseInfo<T> implements Serializable {

    //返回信息
    private String message;

    //返回码
    private int code;

    //返回数据
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

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
