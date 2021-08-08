package com.angular.backend.angular_backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Users", uniqueConstraints = { @UniqueConstraint(columnNames = { "username" }) })
@EntityListeners(AuditingEntityListener.class)
public class UserEneity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", updatable = false, unique = true)
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    public UserEneity(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UserEneity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserEneity{" + "id=" + id + ", username=" + username + ", password=" + password + '}';
    }

}
