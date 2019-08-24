package com.cqut.minishop.service.Impl;


import com.cqut.minishop.dao.UserDAO;
import com.cqut.minishop.entity.User;
import com.cqut.minishop.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public User getUserByName(String userName) {
        return userDAO.selectByUserName(userName);
    }
}
