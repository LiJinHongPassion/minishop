package com.cqut.minishop.controller;

import com.cqut.minishop.service.IUserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource(name = "userService")
    private IUserService userService;


}
