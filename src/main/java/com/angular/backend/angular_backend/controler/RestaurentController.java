package com.angular.backend.angular_backend.controler;

import java.util.List;

import com.angular.backend.angular_backend.Dtos.RestaurentDto;
import com.angular.backend.angular_backend.entities.RestaurentEntity;
import com.angular.backend.angular_backend.services.RestaurentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController

@RequestMapping("/api")
@SecurityRequirement(name = "swagger")

public class RestaurentController {

    @Autowired
    public RestaurentService restaurentService;

    @GetMapping("/restaurents")
    public List<RestaurentEntity> getAllRestaurents() {
        return restaurentService.getAllRestaurents();
    }

    @GetMapping("/restaurent/{id}")
    public RestaurentEntity getRestaurentById(@PathVariable long id) {
        return restaurentService.getRestaurentById(id);
    }

    @PostMapping(value = "/restaurent", consumes = "application/json")
    public ResponseEntity<?> addRestaurent(@RequestBody RestaurentDto restaurentEntity) throws Exception {
        return ResponseEntity.ok(this.restaurentService.createRestaurent(restaurentEntity));
    }

    @PutMapping("/restaurent/{id}")
    public ResponseEntity<?> updateRestaurent(@PathVariable Long id, @RequestBody RestaurentDto restaurentEntity)
            throws Exception {
        if (id > 0) {

            RestaurentEntity updateRes = new RestaurentEntity();
            updateRes.setId(id);
            updateRes.setName(restaurentEntity.getName());
            updateRes.setAddress(restaurentEntity.getAddress());
            updateRes.setPhone(restaurentEntity.getPhone());
            updateRes.setEmail(restaurentEntity.getEmail());
            updateRes.setDescription(restaurentEntity.getDescription());
            updateRes.setLogo(restaurentEntity.getLogo());
            return ResponseEntity.ok(this.restaurentService.updateRestaurent(updateRes));
        } else {
            return ResponseEntity.badRequest().body("Invalid Id");
        }
    }

    @DeleteMapping("/restaurent/{id}")
    public ResponseEntity<?> deleteRestaurent(@PathVariable Long id) throws Exception {
        if (id > 0) {
            return ResponseEntity.ok(this.restaurentService.deleteRestaurent(id));
        } else {
            return ResponseEntity.badRequest().body("Invalid Id");
        }
    }
}
