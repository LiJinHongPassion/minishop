package com.cqut.minishop.controller;

import com.cqut.minishop.entity.User;
import com.cqut.minishop.service.IUserService;
import com.cqut.minishop.util.CookieUtils;
import com.cqut.minishop.util.jwt.JwtService;
import com.cqut.minishop.util.MD5Utils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LJH
 * @date 2019/7/16-6:16
 * @QQ 1755497577
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;

    //需要token验证才能访问
    @RequestMapping("hello")
    public String user(){

        return "hello";
    }


    /**
     * 描述: 登录
     *
     * @author LJH-1755497577 2019/8/24 15:52
     * @param
     * @return java.lang.String
     */
    @PostMapping("login")
    public String login(@RequestParam("username")String userName,
                        @RequestParam("password")String password,
                        HttpServletResponse response,
                        HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();
        map.put("name", userName);

        User user = userService.getUserByName(userName);

        String pwd = MD5Utils.getMd5Hash(password, userName).toString();
        //登录成功  条件：密码匹配，账户状态未注销
        if(pwd.equals(user.getUserPassword())){
            //1:已登录 0：未登录 -1：已注销
            //1. 账户状态为未登录
            CookieUtils.setCookie(response, "authorization", JwtService.createPersonToken(map, "codeAnt"));
            int user_status = user.getUserStatus();
            if(user_status == 0){
                return null;
            }else if(user_status == 1){
                return null;
            }

            //2. 账户状态为已登录
            //3. 账户状态为以注销


        }


        return "登录失败";
    }


}