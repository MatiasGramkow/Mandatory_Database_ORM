package com.mandatory.database.Services;

import com.mandatory.database.Entities.UserEntity;
import com.mandatory.database.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(UserEntity user)
    {
        userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user, String firstName, String lastName, String email)
    {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @Override
    public UserEntity getUserEntityByUserId(long id)
    {
        return userRepository.getUserEntityByUserId(id);
    }

    @Override
    public void deleteUser(UserEntity user)
    {
         userRepository.delete(user);
    }

    @Override
    public List<UserEntity> getAllUsers()
    {
        return userRepository.findAll();
    }
}
