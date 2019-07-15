package com.zerah.hello.web;

import com.zerah.hello.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @ResponseBody
    @RequestMapping("/exception")
    public String testException() throws Exception {
        throw new Exception("Use English to show customer Exception");
    }


    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("Diu MyException ！");
    }


    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "http://www.zerah.cn");
        return "index";
    }

}