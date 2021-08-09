package com.angular.backend.angular_backend.services;

import com.angular.backend.angular_backend.Config.CustomUserDetails;
import com.angular.backend.angular_backend.Dao.UsersDao;
import com.angular.backend.angular_backend.Dtos.UserDto;
import com.angular.backend.angular_backend.entities.UserEneity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsersDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private userService User;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEneity user = this.userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        return customUserDetails;
    }

    public UserEneity save(UserDto user) {
        UserEneity newUser = new UserEneity();
        newUser.setUsername(user.getUsername());
        newUser.setRole(user.getRole());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(newUser);
    }

    public Boolean updateUser(Long id, UserDto user) {
        UserEneity updateUser = this.User.getUser(id);
        updateUser.setUsername(user.getUsername());
        updateUser.setRole(user.getRole());
        updateUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        userDao.save(updateUser);
        return true;
    }

}
