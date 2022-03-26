package com.fms2.fms2.login.service;

import com.fms2.fms2.login.domain.User;
import com.fms2.fms2.login.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService{

    @Autowired
    private LoginMapper loginMapper;

    public boolean checkLogin(User user) {
       return loginMapper.checkLogin(user);
    }
}
