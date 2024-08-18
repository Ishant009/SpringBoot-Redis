package com.api.redis.controller;

import com.api.redis.doa.UserDao;
import com.api.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }
    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        return userDao.get(userId);
    }

    @GetMapping
    public Map<Object, Object> getAll(){
        return userDao.findAll();
    }
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        userDao.delete(userId);
    }
}
