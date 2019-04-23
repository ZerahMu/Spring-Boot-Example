package com.zerah.shiro.service;

import com.zerah.shiro.entity.UserInfo;

/**
 * @Description TODO
 * @Author muning
 * @Date 2019/4/12 14:56
 **/
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
