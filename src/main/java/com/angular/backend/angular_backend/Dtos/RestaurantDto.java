package com.angular.backend.angular_backend.Dtos;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RestaurantDto {
    @Schema(description = "Your restaurant name", type = "string", example = "My Shop")
    @Parameter(name = "restaurant name", description = "Your restaurant name", required = true)
    private String name;

    @Schema(description = "Restaurant address", type = "long", example = "221B Baker Street")
    @Parameter(name = "restaurant description", description = "Your restaurant name", required = true)
    private String address;

    @Schema(description = "Owner phone number", type = "long", example = "9876543210")
    private Long phone;

    @Schema(description = "Owner email address", type = "string", example = "test@demo.com")
    private String email;

    @Schema(description = "Other description about restaurant", type = "string", example = "Punjabi, South Indian, Kathyawadi, Chinese, Puri-Saak, Parotha.")
    private String description;

    private String logo;

}
