package com.angular.backend.angular_backend.Dao;


import com.angular.backend.angular_backend.entities.RestaurentEntity;
import com.angular.backend.angular_backend.entities.UserEneity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurentDao extends JpaRepository<RestaurentEntity,Long> {



}
