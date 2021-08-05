package com.angular.backend.angular_backend.services;

import com.angular.backend.angular_backend.entities.UserEneity;
import java.util.List;

public interface userService {

    public List<UserEneity> getAllUsers();
    public UserEneity getUser(Long id);
    public UserEneity addUser(UserEneity user);
    public UserEneity updateUser(Long id,UserEneity user);

}
