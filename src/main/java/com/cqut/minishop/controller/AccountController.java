package com.cqut.minishop.controller;

import com.cqut.minishop.comment.Result;
import com.cqut.minishop.entity.User;
import com.cqut.minishop.service.IMailService;
import com.cqut.minishop.service.IUserService;
import com.cqut.minishop.util.CookieUtils;
import com.cqut.minishop.util.verificationcode.VerificationCodeUtils;
import com.cqut.minishop.util.jwt.JwtService;
import com.cqut.minishop.util.MD5Utils;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.cqut.minishop.comment.Constants.*;

/**
 * 描述：登录、注册、邮件验证码、用户头像上传
 *
 * @author LJH
 * @date 2019/7/16-6:16
 * @QQ 1755497577
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource(name = "userService")
    private IUserService userService;
    @Resource
    private IMailService mailService;

    //需要token验证才能访问
    @RequestMapping("hello")
    public String user(){

        return "hello";
    }

    /**
     * 描述: 发送邮件验证码
     *
     * @author LJH-1755497577 2019/8/24 21:46
     * @param to 发给谁邮箱
     * @param userName 用户Id
     * @return com.cqut.minishop.comment.Result
     */
    @PostMapping("sendMail")
    public Result sendMail(@RequestParam("to") String to,
                           @RequestParam("username") String userName){
        //验证用户
        User user = userService.getUserByName(userName);
        if( user != null){
            return new Result(false, "用户已注册");
        }

        mailService.sendSimpleMail(to,"MiniShop-登录验证码","验证码：" + VerificationCodeUtils.getCode(userName) + "(三分钟内有效)");
        return new Result(true, null);
    }

    /**
     * 描述: 图片上传
     *
     * @author LJH-1755497577 2019/8/29 20:13
     * @param file
     * @param request
     * @return com.cqut.minishop.comment.Result 图片路径
     */
    @PostMapping("saveHeadPic")
    public Result saveHeadPic(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        Result result = new Result();
        String temp = handleFormUploadByByte(file, request);
        if ( temp != null){
            //成功
            temp = IP_PORT_ADDRESS + "/" + USRE_PIC_PATH + temp;
            result.setCode(GLOBAL_NORMAL_STATUS_INT);
            result.setData(temp);
            return result;
        }

        result.setCode(GLOBAL_ERROR_STATUS_INT);
        result.setErrorMessage("上传失败");
        return result;
    }


    /**
     * 描述: 登录
     *
     * @author LJH-1755497577 2019/8/29 18:21
     * @param userName
     * @param password
     * @param response
     * @param request
     * @return com.cqut.minishop.comment.Result
     */
    @PostMapping("login")
    public Result login(@RequestParam("username")String userName,
                        @RequestParam("password")String password,
                        HttpServletResponse response,
                        HttpServletRequest request){

        Map<String, Object> map = new HashMap<>();
        map.put("name", userName);

        //验证用户
        User user = userService.getUserByName(userName);

        if(user == null){
            return new Result(false, "用户不存在");
        }

        //验证密码
        String pwd = MD5Utils.getMd5Hash(password, userName).toString();
        if(pwd.equals(user.getUserPassword())){
            //1:已登录 0：未登录 -1：已注销
            //1. 账户状态为未登录
            CookieUtils.setCookie(response, "authorization", JwtService.createPersonToken(map, "codeAnt"));
            int user_status = user.getUserStatus();
            if(user_status == 0 || user_status == 1){
                try {
                    userService.changeStatus(user.getUserId(), 1);
                }catch (Exception e){
                    return new Result(false, "服务器繁忙");
                }
                return new Result(true, null);
            }else if(user_status == -1){
                return new Result(false, "用户已注销");
            }
        }

        return new Result(false, "登录失败");
    }

    /**
     * 描述: 注册
     *
     * @author LJH-1755497577 2019/8/27 11:09
     * @param user
     * @return com.cqut.minishop.comment.Result
     */
    @PostMapping("register")
    public Result register(User user,
                           @RequestParam(value = "code", required = false)String code){
        //验证用户
        User userByName = userService.getUserByName(user.getUserName());
        if(userByName != null){
            return new Result(false,"用户名已存在");
        }

        //验证码
        Result verify = Verify(user, code);
        if( verify != null){
            return verify;
        }

        //保存用户
        try {
            userService.save(user);
            return new Result(true,null);
        }catch (Exception e){
            return new Result(false,"注册失败");
        }
    }

    /**
     * 描述: 验证验证码
     *
     * @author LJH-1755497577 2019/8/29 18:12
     * @param user
     * @param code
     * @return com.cqut.minishop.comment.Result
     */
    private Result Verify(User user, String code){
        if(StringUtils.isEmpty(code)){
            return new Result(false, "请输入验证码");
        }

        if(!VerificationCodeUtils.VerifyTime(user.getUserName())){
            return new Result(false, "验证码过期");
        }

        if(!VerificationCodeUtils.Verify(user.getUserName(), code)){
            return new Result(false, "验证码错误");
        }
        return null;
    }


    /**
     * 描述: 写入文件
     *
     * @author LJH-1755497577 2019/8/29 19:24
     * @param file
     * @param request
     * @return java.lang.String 文件路径
     */
    private String handleFormUploadByByte( MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            try {
                String path = request.getServletContext().getRealPath(USRE_PIC_PATH);
                String temp = "/" + System.currentTimeMillis() + file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                FileUtils.writeByteArrayToFile(new File(path + temp), bytes);
                return temp;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

}