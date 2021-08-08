package com.angular.backend.angular_backend.services;

import java.util.List;

import com.angular.backend.angular_backend.Dao.RestaurantDao;
import com.angular.backend.angular_backend.Dtos.RestaurantDto;
import com.angular.backend.angular_backend.Exceptions.NotFound;
import com.angular.backend.angular_backend.entities.RestaurantEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantDao restaurant;

    @Override
    public List<RestaurantEntity> getAllRestaurants() {
        return this.restaurant.findAll();
    }

    @Override
    public RestaurantEntity getRestaurantById(Long id) {
        return this.restaurant.findById(id).orElseThrow(() -> new NotFound("User doesn't exit"));
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurant) {

        RestaurantEntity newRes = new RestaurantEntity();
        newRes.setId(0L);
        newRes.setName(restaurant.getName());
        newRes.setAddress(restaurant.getAddress());
        newRes.setPhone(restaurant.getPhone());
        newRes.setEmail(restaurant.getEmail());
        newRes.setDescription(restaurant.getDescription());
        newRes.setLogo(restaurant.getLogo());
        this.restaurant.save(newRes);
        return restaurant;
    }

    @Override
    public RestaurantEntity updateRestaurant(RestaurantEntity restaurant) {
        RestaurantEntity existing = this.restaurant.findById(restaurant.getId())
                .orElseThrow(() -> new NotFound("Restaurant doesn't exit"));

        this.restaurant.save(restaurant);

        return existing;
    }

    @Override
    public Boolean deleteRestaurant(Long id) {
        RestaurantEntity existing = this.restaurant.findById(id)
                .orElseThrow(() -> new NotFound("Restaurant doesn't exit"));

        this.restaurant.delete(existing);
        return true;

    }

}
