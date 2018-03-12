package myBlog.Entity;

public enum ResponseCode {

    OK(10000,"处理成功"),
    INNER_ERROR(500,"内部错误"),
    COMMON_ERROR(99999,"其他错误")
    ;
    public int code;
    public String message;
    ResponseCode(int code,String message){
        this.code = code;
        this.message = message;
    }
}
