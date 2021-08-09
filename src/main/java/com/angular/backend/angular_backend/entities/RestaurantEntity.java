package com.angular.backend.angular_backend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Restaurent", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@EntityListeners(AuditingEntityListener.class)
@Data
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", length = 20)
    private String name;
    @Column(name = "address", length = 255)
    private String address;
    @Column(name = "phone", length = 20)
    private Long phone;
    @Column(name = "email", length = 100)
    private String email;
    @Column(name = "description", length = 255)
    private String description;
    @Column(name = "logo", length = 225)
    @JsonIgnore
    private String logo;



}
