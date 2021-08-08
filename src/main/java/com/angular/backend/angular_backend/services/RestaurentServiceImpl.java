package com.angular.backend.angular_backend.services;

import java.util.List;

import com.angular.backend.angular_backend.Dao.RestaurentDao;
import com.angular.backend.angular_backend.Dtos.RestaurentDto;
import com.angular.backend.angular_backend.Exceptions.NotFound;
import com.angular.backend.angular_backend.entities.RestaurentEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurentServiceImpl implements RestaurentService {

    @Autowired
    private RestaurentDao restaurent;

    @Override
    public List<RestaurentEntity> getAllRestaurents() {
        return this.restaurent.findAll();
    }

    @Override
    public RestaurentEntity getRestaurentById(Long id) {
        return this.restaurent.findById(id).orElseThrow(() -> new NotFound("User doesn't exit"));
    }

    @Override
    public RestaurentDto createRestaurent(RestaurentDto restaurent) {

        RestaurentEntity newRes = new RestaurentEntity();
        newRes.setId(0L);
        newRes.setName(restaurent.getName());
        newRes.setAddress(restaurent.getAddress());
        newRes.setPhone(restaurent.getPhone());
        newRes.setEmail(restaurent.getEmail());
        newRes.setDescription(restaurent.getDescription());
        newRes.setLogo(restaurent.getLogo());
        this.restaurent.save(newRes);
        return restaurent;
    }

    @Override
    public RestaurentEntity updateRestaurent(RestaurentEntity restaurent) {
        RestaurentEntity existing = this.restaurent.findById(restaurent.getId())
                .orElseThrow(() -> new NotFound("Restaurent doesn't exit"));

        this.restaurent.save(restaurent);

        return existing;
    }

    @Override
    public Boolean deleteRestaurent(Long id) {
        RestaurentEntity existing = this.restaurent.findById(id)
                .orElseThrow(() -> new NotFound("Restaurent doesn't exit"));

        this.restaurent.delete(existing);
        return true;

    }

}
