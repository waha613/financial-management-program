package com.fms2.fms2.login.control;

import com.fms2.fms2.json.ReturnJSONObject;
import com.fms2.fms2.login.domain.User;
import com.fms2.fms2.login.service.LoginService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.MessageDigest;

@Controller
@RequestMapping("login")
public class LoginControl {
    @Autowired
    private LoginService loginService;

    @RequestMapping("checkLogin")
    @ResponseBody
    public ReturnJSONObject checkLogin(User user, ReturnJSONObject returnJSON){
        try {
            boolean b;
            String password = user.getPassword();
            MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] output = md.digest(password.getBytes());
            //采用Base64算法将加密后的字节信息转成字符串
            user.setPassword(Base64.encodeBase64String(output));
            if(!(b = loginService.checkLogin(user))){
                returnJSON.setData("账号或密码错误，请检查后重新再试");
            };
            returnJSON.setSuccess(b);
        } catch (Exception e) {
            returnJSON.setData("系统异常，请联系管理员");
            returnJSON.setData1(e);
        }
        return returnJSON;
    }
}
