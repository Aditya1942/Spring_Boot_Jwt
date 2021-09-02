package com.angular.backend.angular_backend.services;

import com.angular.backend.angular_backend.Dtos.RestaurantDto;
import com.angular.backend.angular_backend.entities.RestaurantEntity;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    List<RestaurantEntity> getAllRestaurants();

    Optional<RestaurantEntity> getRestaurantById(Long id);

    RestaurantDto createRestaurant(RestaurantDto restaurant);

    RestaurantEntity updateRestaurant(RestaurantEntity restaurant);

    Boolean deleteRestaurant(Long id);
}
