package com.eleme.service;

import com.eleme.dto.UserLoginDTO;
import com.eleme.entity.User;

public interface UserService {

    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}