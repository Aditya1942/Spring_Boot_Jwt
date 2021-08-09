package com.angular.backend.angular_backend.controler;

import com.angular.backend.angular_backend.Dtos.UserDto;
import com.angular.backend.angular_backend.Helper.JwtUtil;
import com.angular.backend.angular_backend.Models.JwtRequest;
import com.angular.backend.angular_backend.Models.JwtResponse;
import com.angular.backend.angular_backend.entities.UserEneity;
import com.angular.backend.angular_backend.services.UserDetailServiceImpl;
import com.angular.backend.angular_backend.services.userService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")

@SecurityRequirement(name = "swagger")
public class userControler {
    @Autowired
    private userService User;
    @Autowired
    private UserDetailServiceImpl userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {
        return ResponseEntity.ok(this.userDetailsService.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userDetails);

            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception e) {
            // TODO: handle exception

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    public List<UserEneity> Allusers() {
        return this.User.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserEneity getUser(@PathVariable("id") Long id) {
        return this.User.getUser(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto user) {

            return ResponseEntity.ok(this.userDetailsService.updateUser(id, user));

    }

}
