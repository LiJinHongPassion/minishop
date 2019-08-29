package com.cqut.minishop.service;


import com.cqut.minishop.entity.User;

public interface IUserService {
    /**
     * 描述: 根据名字查用户
     *
     * @author LJH-1755497577 2019/8/29 20:51
     * @param userName
     * @return com.cqut.minishop.entity.User
     */
    User getUserByName(String userName);

    /**
     * 描述: 添加
     *
     * @author LJH-1755497577 2019/8/29 20:51
     * @param user
     * @return int
     */
    int save(User user);

    /**
     * 描述: 更改用户状态
     *
     * @author LJH-1755497577 2019/8/29 20:52
     * @param userId
     * @param status
     * @return void
     */
    void changeStatus(String userId, int status);
}
