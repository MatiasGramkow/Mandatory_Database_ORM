package com.mandatory.database.Controllers;

import com.mandatory.database.Entities.UserEntity;
import com.mandatory.database.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/users/create")
    public ResponseEntity createUser(String firstName, String lastName, String email)
    {
        try
        {
            UserEntity user = new UserEntity(firstName, lastName, email);
            userService.createUser(user);
            return ResponseEntity.status(200).body("User '" + user.getFirstName() + " " + user.getLastName() + "' has been created");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in create");
        }
    }

    @PostMapping("/users/update")
    public ResponseEntity updateUser(@RequestParam(name = "user_id") Long userId, String firstName, String lastName, String email)
    {
        try
        {
            UserEntity user = userService.getUserEntityByUserId(userId);
            userService.updateUser(user, firstName, lastName, email);
            return ResponseEntity.status(200).body("Updated to'" + user.getFirstName() + " " + user.getLastName() + "'");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in update");
        }
    }

    @RequestMapping("/users/delete")
    public ResponseEntity deleteUser(@RequestParam(name = "user_id") Long userId)
    {
        try
        {
            UserEntity user = userService.getUserEntityByUserId(userId);
            userService.deleteUser(user);
            return ResponseEntity.status(200).body("User '" + user.getFirstName() + " " + user.getLastName() + "' has been deleted");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error in delete");
        }
    }

    @PostMapping("/users")
    public ResponseEntity getAllUsers()
    {
        try
        {
            List<UserEntity> users = userService.getAllUsers();
            return ResponseEntity.status(200).body("Users: '" + users + "'");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Could'nt retrieve all users");
        }
    }

    @PostMapping("/user")
    public ResponseEntity getUserById(@RequestParam(name = "user_id") Long userId)
    {
        try
        {
            UserEntity user = userService.getUserEntityByUserId(userId);
            return ResponseEntity.status(200).body("Found: '" + user.getFirstName() + " " + user.getLastName() + "'");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't find that user");
        }
    }

}
