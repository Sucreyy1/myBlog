package myBlog.controller;

import myBlog.Entity.ResponseInfo;
import myBlog.Entity.UserInfo;
import myBlog.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public ResponseInfo register(@RequestParam(name = "userName") String userName,
                                 @RequestParam(name = "password") String password
    ) {
        ResponseInfo responseInfo = new ResponseInfo();
        List<UserInfo> all = userInfoRepository.findAll();
        if(null!=all&&all.size()>3){
            responseInfo.setMessage("暂不开放注册");
            return responseInfo;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setAge(11);
        userInfo.setHandphone(1111);
        userInfo.setNickName("yy");
        userInfo.setQq("5931434487");
        userInfoRepository.save(userInfo);
        responseInfo.setMessage("注册成功");
        logger.info("注册成功");
        return responseInfo;
    }

}
