package com.angular.backend.angular_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "Restaurent", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
@EntityListeners(AuditingEntityListener.class)
@Data
@Schema
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Schema(description = "Your restaurant name", type = "string", example = "My Shop")
    @Column(name = "name", length = 20)
    private String name;

    @Column(name = "address", length = 255)
    @Schema(description = "Restaurant address", type = "long", example = "221B Baker Street")
    private String address;

    @Column(name = "phone", length = 20)
    @Schema(description = "Owner phone number", type = "long", example = "9876543210")
    private Long phone;

    @Column(name = "email", length = 100)
    @Schema(description = "Owner email address", type = "string", example = "test@demo.com")
    private String email;

    @Column(name = "description", length = 255)
    @Schema(description = "Other description about restaurant", type = "string", example = "Punjabi, South Indian, Kathyawadi, Chinese, Puri-Saak, Parotha.")
    private String description;

    @Column(name = "logo", length = 225)
    @JsonIgnore
    private String logo;


}
