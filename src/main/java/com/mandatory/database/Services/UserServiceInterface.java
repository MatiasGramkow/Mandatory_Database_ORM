package com.mandatory.database.Services;

import com.mandatory.database.Entities.UserEntity;

import java.util.List;

public interface UserServiceInterface
{
    void createUser(UserEntity user);

    UserEntity updateUser(UserEntity user, String firstName, String lastName, String email);

    UserEntity getUserEntityByUserId(long id);

    void deleteUser(UserEntity user);

    List<UserEntity> getAllUsers();
}
