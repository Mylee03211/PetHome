package com.itld.demos.common;

//接口统一返回包装类
public class Result {
    private String code;//用于判断成功或失败
    private String msg;
    private Object data;

    //成功的函数
    public static Result success(){
        return new Result(Constant.CODE_200,"",null);
    }
    public static Result success(Object data){
        return new Result(Constant.CODE_200,"",data);
    }
    //失败的函数
    public static Result error(String code,String msg){
        return new Result(code,msg,null);
    }
    public static Result error(){
        return new Result(Constant.CODE_500,"系统错误",null);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
