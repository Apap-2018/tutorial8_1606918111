package com.apap.tutorial8.service;

import com.apap.tutorial8.model.UserRoleModel;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleService {
    UserRoleModel addUser(UserRoleModel user);
    public String encrypt(String password);
    public UserRoleModel findUserByUsername(String username);
    void changePassword(UserRoleModel user, String newPassword);
}