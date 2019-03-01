package com.zgs.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 * @author zgs
 * @since 2019/03/01
 */
public class MyException extends RuntimeException{

    @Setter
    @Getter
    private int code;

    public MyException() {}

    public MyException(int code, String message) {
        super(message);
        this.setCode(code);
    }
}
