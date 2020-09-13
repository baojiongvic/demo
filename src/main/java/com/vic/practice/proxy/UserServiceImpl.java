package com.vic.practice.proxy;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save");
    }
}
