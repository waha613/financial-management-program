package com.fms2.fms2.login.mapper;

import com.fms2.fms2.login.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    boolean checkLogin(User user);
}
