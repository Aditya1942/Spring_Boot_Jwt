package com.angular.backend.angular_backend.services;

import com.angular.backend.angular_backend.Exceptions.NotFound;
import com.angular.backend.angular_backend.entities.UserEneity;
import com.angular.backend.angular_backend.Dao.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private UsersDao users;

    @Override
    public List<UserEneity> getAllUsers() {
        return this.users.findAll();
    }

    @Override
    public UserEneity getUser(Long id) {
        return this.users.findById(id).orElseThrow(() -> new NotFound("User doesn't exit"));
    }

    // @Override
    // public UserEneity addUser(UserEneity user) {
    // this.users.save(user);
    // return user;
    // }

    // @Override
    // public UserEneity updateUser(Long id, UserEneity user) {

    // UserEneity existing = this.users.findById(id).orElseThrow(() -> new
    // NotFound("User doesn't exit"));
    // existing.setUsername(user.getUsername());

    // this.users.save(existing);
    // return null;
    // }
}
