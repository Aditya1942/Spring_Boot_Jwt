package com.angular.backend.angular_backend.Dao;


import com.angular.backend.angular_backend.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends JpaRepository<RestaurantEntity,Long> {



}
