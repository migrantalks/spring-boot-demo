package com.zgs.exception;

import lombok.Data;

/**
 * 错误信息响应
 * @author zgs
 * @since 2019/03/01
 */
@Data
public class ErrorResponse {

    private int code;
    private String message;


    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
