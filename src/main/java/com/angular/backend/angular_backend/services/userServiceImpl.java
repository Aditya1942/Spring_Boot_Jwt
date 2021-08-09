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
        return users.findAll();
    }

    @Override
    public UserEneity getUser(Long id) {
        return users.findById(id).orElseThrow(() -> new NotFound("User doesn't exit"));
    }


}
