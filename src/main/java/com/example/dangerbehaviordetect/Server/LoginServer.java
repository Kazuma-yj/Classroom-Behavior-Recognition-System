package com.example.dangerbehaviordetect.Server;

import com.example.dangerbehaviordetect.entity.User;

public interface LoginServer {
    public User login(String mail, String password);

    public int register(String mail, String password, String uName, String code);
}
