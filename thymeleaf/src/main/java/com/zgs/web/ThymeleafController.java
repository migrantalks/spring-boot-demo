package com.zgs.web;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zgs
 * @since 2019/02/27
 */
@Controller
@RequestMapping
public class ThymeleafController {


    @GetMapping("/index")
    public String index(HttpServletRequest request) {

        request.setAttribute("title", "the thymeleaf page");
        request.setAttribute("desc", "welcome to thymeleaf page");

        Author author = new Author();
        author.setAge(30);;
        author.setName("zhongxia");
        request.setAttribute("author", author);

        return "index";
    }

    @Data
    class Author {
        private int age;
        private String name;
    }
}
