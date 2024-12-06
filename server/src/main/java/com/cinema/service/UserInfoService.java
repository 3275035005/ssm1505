package com.cinema.service;

import com.cinema.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo>{

    /**
     * 通过账号查询数据
     * @param username
     * @return
     */
    UserInfo getUserInfoByUsername(String username);

}
