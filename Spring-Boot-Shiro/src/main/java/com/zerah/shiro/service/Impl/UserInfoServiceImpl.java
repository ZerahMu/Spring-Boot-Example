package com.zerah.shiro.service.Impl;

import com.zerah.shiro.dao.UserInfoDao;
import com.zerah.shiro.entity.UserInfo;
import com.zerah.shiro.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author muning
 * @Date 2019/4/12 14:57
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
