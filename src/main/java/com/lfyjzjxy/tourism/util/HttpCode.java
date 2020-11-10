package com.lfyjzjxy.tourism.util;

import lombok.Data;

@Data
public class HttpCode {

    private int code;
    private String msg;

    /**
     * 返回
     */
    private Object data;
    // 分页

    public HttpCode() {

    }

    public HttpCode(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static HttpCode success(String msg, Object data){
        return new HttpCode(200,msg,data);

    }
    public static HttpCode success(Object data){
        return new HttpCode(200,"",data);

    }
    public static HttpCode success(String msg){
        return new HttpCode(200,msg,null);

    }
    public static HttpCode success(){
        return new HttpCode(200,"",null);

    }
    public static HttpCode fail(){
        return new HttpCode(500,"",null);

    }

    public static HttpCode fail(String msg, Object data){
        return new HttpCode(500,msg,data);

    }
    public static HttpCode fail(String msg){
        return new HttpCode(500,msg,null);

    }

}
