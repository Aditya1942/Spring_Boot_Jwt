package com.angular.backend.angular_backend.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    @Schema(description = " ", type = "string", example = "ROLE_USER")
    private String role;


}
