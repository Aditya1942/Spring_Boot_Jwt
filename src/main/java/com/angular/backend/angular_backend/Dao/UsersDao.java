package com.angular.backend.angular_backend.Dao;


import com.angular.backend.angular_backend.entities.UserEneity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<UserEneity,Long> {

    UserEneity findByUsername(String username);


}
