package com.cinema.mapper;

import com.cinema.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserInfoMapper继承基类
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo getUserInfoByUsername(String username);
}