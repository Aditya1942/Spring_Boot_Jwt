package com.angular.backend.angular_backend.services;

import com.angular.backend.angular_backend.entities.UserEneity;
import java.util.List;

public interface userService {

     List<UserEneity> getAllUsers();

     UserEneity getUser(Long id);

}
