package com.angular.backend.angular_backend.services;

import com.angular.backend.angular_backend.Dao.UsersDao;
import com.angular.backend.angular_backend.Dtos.UserDto;
import com.angular.backend.angular_backend.Dtos.UserUpdateDto;
import com.angular.backend.angular_backend.entities.UserEneity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private UsersDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEneity user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public UserEneity save(UserDto user) {
        UserEneity newUser = new UserEneity();
        newUser.setUsername(user.getUsername());

        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

    public UserEneity updateUser(Long id, UserUpdateDto user) {
        UserEneity newUser = new UserEneity();

        newUser.setUsername(user.getUsername());

        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

}
