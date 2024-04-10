package com.aliakkoyun.BasicJwtToken.controller;

import com.aliakkoyun.BasicJwtToken.dto.AuthRequest;
import com.aliakkoyun.BasicJwtToken.dto.CreateUserRequest;
import com.aliakkoyun.BasicJwtToken.model.User;
import com.aliakkoyun.BasicJwtToken.service.JwtService;
import com.aliakkoyun.BasicJwtToken.service.UserService;
import jdk.jfr.Frequency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController  {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public UserController(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/addNewUser")
    public User addNewUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(request.username());
        }
        throw new UsernameNotFoundException("invalid username {} " + request.username());
    }

    @GetMapping("/user")
    public String getUser(){
        return "This account has USER permission";
    }

    @GetMapping("/admin")
    public String getAdmin(){
        return "This account has ADMIN permission";
    }

}
