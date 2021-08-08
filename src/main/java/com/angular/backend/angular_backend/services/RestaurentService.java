package com.angular.backend.angular_backend.services;

import java.util.List;

import com.angular.backend.angular_backend.Dtos.RestaurentDto;
import com.angular.backend.angular_backend.entities.RestaurentEntity;

public interface RestaurentService {

    public List<RestaurentEntity> getAllRestaurents();

    public RestaurentEntity getRestaurentById(Long id);

    public RestaurentDto createRestaurent(RestaurentDto restaurent);

    public RestaurentEntity updateRestaurent(RestaurentEntity restaurent);

    public Boolean deleteRestaurent(Long id);
}
