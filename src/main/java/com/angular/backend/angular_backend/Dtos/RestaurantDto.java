package com.angular.backend.angular_backend.Dtos;

import lombok.Data;

@Data
public class RestaurantDto {
    private String name;
    private String address;
    private Long phone;
    private String email;
    private String description;
    private String logo;

}
