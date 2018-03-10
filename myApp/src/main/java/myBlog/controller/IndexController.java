package myBlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String login(){
        return "index";
    }

    @RequestMapping("/index/login")
    @ResponseBody
    public String checkLogin(){
        return "please login";
    }

}
