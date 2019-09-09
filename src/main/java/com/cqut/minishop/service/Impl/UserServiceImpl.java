package com.cqut.minishop.service.Impl;

import com.cqut.minishop.dao.UserDAO;
import com.cqut.minishop.entity.User;
import com.cqut.minishop.service.IUserService;
import com.cqut.minishop.util.EntityIDUtil;
import com.cqut.minishop.util.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static com.cqut.minishop.comment.Constants.IP_PORT_ADDRESS;
import static com.cqut.minishop.comment.Constants.USRE_PIC_PATH;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserDAO userDAO;

    @Override
    public User getUserByName(String userName) {
        return userDAO.selectByUserName(userName);
    }

    @Override
    @Transactional( rollbackFor = Exception.class)
    public int save(User user) {
        user.setUserId(EntityIDUtil.createId());
        user.setUserPassword(MD5Utils.getMd5Hash(user.getUserPassword(), user.getUserId()).toString());

        user.setUserPic(IP_PORT_ADDRESS + "/" + USRE_PIC_PATH + "/default.jpg");
        user.setUserStatus(0);
        return userDAO.insert(user);
    }

    @Override
    @Transactional( rollbackFor = Exception.class)
    public void changeStatus(String userId, int status) {
        userDAO.changeStatus(userId, status);
    }

    @Override
    @Transactional( rollbackFor = Exception.class)
    public User updateByPrimaryKeySelective(User user) {

        if(user.getUserPassword() != null){
            user.setUserPassword(MD5Utils.getMd5Hash(user.getUserPassword(), user.getUserId()).toString());
        }

        userDAO.updateByPrimaryKeySelective(user);

        User user_temp = userDAO.selectByPrimaryKey(user.getUserId());
        user_temp.setUserPassword("");
        return user_temp;
    }


}
