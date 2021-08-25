package com.angular.backend.angular_backend.controler;

import java.util.List;

import com.angular.backend.angular_backend.Dtos.RestaurantDto;
import com.angular.backend.angular_backend.entities.RestaurantEntity;
import com.angular.backend.angular_backend.services.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "swagger")
public class RestaurantsController {

    @Autowired
    public RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public RestaurantEntity getRestaurantById(@PathVariable long id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping(value = "/restaurant", consumes = "application/json")
    public ResponseEntity<?> addRestaurant(@RequestBody RestaurantDto restaurantEntity) throws Exception {
        return ResponseEntity.ok(this.restaurantService.createRestaurant(restaurantEntity));
    }

    @PutMapping("/restaurant/{id}")
    public ResponseEntity<?> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantDto restaurantEntity)
            throws Exception {
        if (id > 0) {

            RestaurantEntity updateRes = new RestaurantEntity();
            updateRes.setId(id);
            updateRes.setName(restaurantEntity.getName());
            updateRes.setAddress(restaurantEntity.getAddress());
            updateRes.setPhone(restaurantEntity.getPhone());
            updateRes.setEmail(restaurantEntity.getEmail());
            updateRes.setDescription(restaurantEntity.getDescription());
            updateRes.setLogo(restaurantEntity.getLogo());
            return ResponseEntity.ok(this.restaurantService.updateRestaurant(updateRes));
        } else {
            return ResponseEntity.badRequest().body("Invalid Id");
        }
    }

    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id) throws Exception {
        if (id > 0) {
            return ResponseEntity.ok(this.restaurantService.deleteRestaurant(id));
        } else {
            return ResponseEntity.badRequest().body("Invalid Id");
        }
    }
}
