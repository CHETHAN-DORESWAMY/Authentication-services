package com.ust.spring_security_day1.controller;

import com.ust.spring_security_day1.dto.Userdto;
import com.ust.spring_security_day1.entity.UserInfo;
import com.ust.spring_security_day1.service.JwtService;
import com.ust.spring_security_day1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public UserInfo registerUser(@RequestBody Userdto userdto){
        return userService.register(userdto);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody Userdto userdto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userdto.getName(),userdto.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userdto.getName());
        }
        return "FAIL";
    }

    @GetMapping("/validate/token")
    public Boolean validateToken(@RequestParam String token){
        jwtService.validateToken(token);
        return true;
    }



}
