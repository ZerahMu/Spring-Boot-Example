package com.zerah.shiro.dao;

import com.zerah.shiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description TODO
 * @Author muning
 * @Date 2019/4/12 14:58
 **/
public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
