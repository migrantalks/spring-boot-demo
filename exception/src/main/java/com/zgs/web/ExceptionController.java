package com.zgs.web;

import com.zgs.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zgs
 * @since 2019/03/01
 */
@Controller
public class ExceptionController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/test")
    public String testException(Integer num) {
        if (null == num) {
            throw new MyException(400, "参数num不能为空！");
        }

        int number = 2 * num;
        return "result:" + number;
    }

    @RequestMapping(value = "/error/{code}")
    public String error(@PathVariable int code) {
        String pager = "";
        switch (code) {
            case 403:
                pager = "/error/403";
                break;
            case 404:
                pager = "/error/404";
                break;
            case 500:
                pager = "/error/500";
                break;
        }
        return pager;
    }
}
