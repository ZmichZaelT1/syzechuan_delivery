package com.syzechuan.service;

import com.syzechuan.dto.UserLoginDTO;
import com.syzechuan.entity.User;

public interface UserService {

    User wxLogin(UserLoginDTO userLoginDTO);
}
