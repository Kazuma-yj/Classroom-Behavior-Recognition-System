package com.example.dangerbehaviordetect.Server.impl;

import com.example.dangerbehaviordetect.Mapper.UserMapper;
import com.example.dangerbehaviordetect.Mapper.VCodeMapper;
import com.example.dangerbehaviordetect.Server.LoginServer;
import com.example.dangerbehaviordetect.entity.User;
import com.example.dangerbehaviordetect.entity.VCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class LoginServerA implements LoginServer {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VCodeMapper vCodeMapper;

    @Override
    public User login(String mail, String password) {
        return userMapper.login(mail, password);
    }


    /**
     *
     * @Body  user
     * @param code
     * @return:
     *     -2:邮箱已注册
     *     -1:验证码错误
     *     >0:自动分配的ID
     */
    @Override
    public int register(User user, String code) {
        //判断是否已经注册
        User user1 = userMapper.getByMail(user.getMail());
        if(user1 != null) { return -2; }

        //判断验证码是否正确
        List<VCode> codes = vCodeMapper.getCode(user.getMail(), code);
        boolean isOK = false;
        for(VCode s : codes) {
            LocalDateTime cTime = s.getCTime();
            LocalDateTime current = LocalDateTime.now();
            if (Duration.between(cTime, current).toMillis() <= 600000) {
                isOK = true;
                break;
            }
        }
        if(!isOK) { return -1; }

        //注册
        userMapper.register(user);
        return user.getUID();
    }
}
