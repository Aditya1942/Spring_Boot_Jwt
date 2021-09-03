package com.angular.backend.angular_backend.controler;

import com.angular.backend.angular_backend.Dtos.RestaurantDto;
import com.angular.backend.angular_backend.entities.RestaurantEntity;
import com.angular.backend.angular_backend.services.RestaurantService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "swagger")
public class RestaurantsController {

    static final String GET_SPECIFIS_DESC = "Gets specific restaurant with id.";
    @Autowired
    public RestaurantService restaurantService;

    @GetMapping("/restaurants")

    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @Parameter(name = "id" ,example = "1" , allowEmptyValue = false,required = true,description = "Enter restaurent id")
    @GetMapping("/restaurant/{id}")
    @Operation(
            summary = GET_SPECIFIS_DESC,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "SUCCESS",
                            content = @Content(schema = @Schema(implementation = RestaurantDto.class))),
                    @ApiResponse(responseCode = "404", description = "NOT_FOUND", content = @Content(schema = @Schema())),
                    @ApiResponse(
                            responseCode = "500",
                            description = "SERVER_ERROR",
                            content = @Content(schema = @Schema())
                    )
            }
    )

    public ResponseEntity<?> getRestaurantById(@PathVariable long id) {
        Optional<RestaurantEntity> res = restaurantService.getRestaurantById(id);

        if (res.isPresent()) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("{\n" +
                        "  \"message\": \"No restaurant found\",\n" +
                        "}");
    }

    @PostMapping(value = "/restaurant", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> addRestaurant(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Book to add.", required = true,
            content = @Content(
                    schema = @Schema(implementation = RestaurantDto.class))
    ) RestaurantDto restaurantEntity) throws Exception {
        return ResponseEntity.ok(this.restaurantService.createRestaurant(restaurantEntity));
    }
    @Parameter(name = "id" ,example = "1" , allowEmptyValue = false,required = true,description = "Enter restaurent id")
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
    @Parameter(name = "id" ,example = "1" , allowEmptyValue = false,required = true,description = "Enter restaurent id")
    @DeleteMapping("/restaurant/{id}")
    public ResponseEntity<?> deleteRestaurant(@PathVariable Long id) throws Exception {
        if (id > 0) {
            return ResponseEntity.ok(this.restaurantService.deleteRestaurant(id));
        } else {
            return ResponseEntity.badRequest().body("Invalid Id");
        }
    }
}
