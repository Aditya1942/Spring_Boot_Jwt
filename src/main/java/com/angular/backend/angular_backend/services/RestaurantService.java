package com.angular.backend.angular_backend.services;

import java.util.List;

import com.angular.backend.angular_backend.Dtos.RestaurantDto;
import com.angular.backend.angular_backend.entities.RestaurantEntity;

public interface RestaurantService {

    public List<RestaurantEntity> getAllRestaurants();

    public RestaurantEntity getRestaurantById(Long id);

    public RestaurantDto createRestaurant(RestaurantDto restaurant);

    public RestaurantEntity updateRestaurant(RestaurantEntity restaurant);

    public Boolean deleteRestaurant(Long id);
}
