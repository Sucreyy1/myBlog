package myBlog.controller;

import myBlog.Entity.ResponseCode;
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

    /**
     * 访问主页默认跳转到index.html页面
     * @return
     */
    @RequestMapping("/")
    public String login() {
        return "index";
    }

    /**
     * 用户注册时调用
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping("/user/register")
    @ResponseBody
    public ResponseInfo register(@RequestParam(name = "userName") String userName,
                                 @RequestParam(name = "password") String password
    ) {
        ResponseInfo<String> responseInfo = new ResponseInfo<>();
        try {
            List<UserInfo> all = userInfoRepository.findAll();
            if(null!=all&&all.size()>3){
                responseInfo.setResponseCode(ResponseCode.COMMON_ERROR);
                //todo 下面这个后面可以删除,枚举里面已经定义信息了
                responseInfo.setMessage("都给你说了还在开发,你注册你妹呢???(#滑稽脸)");
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
            responseInfo.setResponseCode(ResponseCode.OK);
            //todo 下面这个后面可以删除,枚举里面已经定义信息了
            responseInfo.setMessage("都给你说了还在开发,你注册你妹呢???(#滑稽脸)");
            logger.info("{},注册成功",userName);
        } catch (Exception e) {
            logger.info(e.getMessage());
            responseInfo.setResponseCode(ResponseCode.INNER_ERROR);
            //todo 下面这个后面可以删除,枚举里面已经定义信息了
            responseInfo.setMessage("内部异常...");
            return responseInfo;
        }
        return responseInfo;
    }

}
