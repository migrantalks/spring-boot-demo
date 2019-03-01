package com.zgs.config;

import com.zgs.exception.ErrorResponse;
import com.zgs.exception.MyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author zgs
 * @since 2019/03/01
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{


    /**
     * 捕获自定义的异常
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(MyException.class)
    public ErrorResponse myExceptionHandler(HttpServletRequest request,
                                            HttpServletResponse response,
                                            final Exception e) {

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        MyException exception = (MyException) e;
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }


    /**
     * 捕获 RuntimeException
     *
     * @param request
     * @param response
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse runtimeExceptionHandler(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 final Exception e) {

        response.setStatus(HttpStatus.BAD_REQUEST.value());
        RuntimeException exception = (RuntimeException) e;
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
    }

    /**
     *  处理不同类型异常
     *
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
                                                             Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {
        // 方法无效
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) ex;
            return new ResponseEntity<>(new ErrorResponse(status.value(), exception.getBindingResult().getAllErrors().get(0).getDefaultMessage()), status);
        }

        // 参数转换失败
        if (ex instanceof MethodArgumentTypeMismatchException) {
            MethodArgumentTypeMismatchException exception = (MethodArgumentTypeMismatchException) ex;
            logger.error("参数转换失败，方法：" + exception.getParameter().getMethod().getName() + "，参数：" + exception.getName()
                    + ",信息：" + exception.getLocalizedMessage());
            return new ResponseEntity<>(new ErrorResponse(status.value(), "参数转换失败"), status);
        }

        return new ResponseEntity<>(new ErrorResponse(status.value(), "参数转换失败"), status);
    }
}
