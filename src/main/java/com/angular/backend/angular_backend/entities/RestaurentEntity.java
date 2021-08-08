package com.angular.backend.angular_backend.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Restaurent", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@EntityListeners(AuditingEntityListener.class)

public class RestaurentEntity {

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

    public RestaurentEntity() {
    }

    public RestaurentEntity(Long id, String name, String address, Long phone, String email, String description,
            String logo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.logo = logo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", address='" + getAddress() + "'"
                + ", phone='" + getPhone() + "'" + ", email='" + getEmail() + "'" + ", description='" + getDescription()
                + "'" + ", logo='" + getLogo() + "'" + "}";
    }

}
