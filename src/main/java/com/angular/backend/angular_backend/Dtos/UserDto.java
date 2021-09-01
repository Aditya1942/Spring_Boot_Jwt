package com.angular.backend.angular_backend.Dtos;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    @Schema(description = "ROLE_USER can only excess restaurent api", type = "string", example = "ROLE_USER")
    private String role;


}
