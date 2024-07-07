package com.example.dangerbehaviordetect.Server;

import com.example.dangerbehaviordetect.entity.User;

public interface LoginServer {
    public User login(String mail, String password);

    public int register(User user, String code);
}
