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


}
