package com.angular.backend.angular_backend.Dtos;

public class RestaurantDto {
    private String name;
    private String address;
    private Long phone;
    private String email;
    private String description;
    private String logo;

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
        return "{" + " name='" + getName() + "'" + ", address='" + getAddress() + "'" + ", phone='" + getPhone() + "'"
                + ", email='" + getEmail() + "'" + ", description='" + getDescription() + "'" + ", logo='" + getLogo()
                + "'" + "}";
    }

}
