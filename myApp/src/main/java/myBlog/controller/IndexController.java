package myBlog.controller;

import myBlog.Entity.UserInfo;
import myBlog.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    private static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping("/")
    public String login() {
        return "index";
    }

    @RequestMapping("/index/login")
    @ResponseBody
    public String checkLogin() {
        return "please login";
    }

    @RequestMapping("/user/register")
    @ResponseBody
    public UserInfo register(@RequestParam(name = "userName") String userName,
                             @RequestParam(name = "password") String password
    ) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setAge(11);
        userInfo.setHandphone(1111);
        userInfo.setNickName("yy");
        userInfo.setQq("5931434487");
        userInfoRepository.save(userInfo);
        logger.info("注册成功");
        return userInfo;
    }

}
