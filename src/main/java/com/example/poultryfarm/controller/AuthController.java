package com.example.poultryfarm.controller;

import com.example.poultryfarm.model.AuthenticationRequest;
import com.example.poultryfarm.model.AuthenticationResponse;
import com.example.poultryfarm.service.UserService;
import com.example.poultryfarm.util.JwtUtil;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authRequest) {
        logger.info("Login attempt for username: {}", authRequest.getUsername());
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Authentication successful for username: {}", authRequest.getUsername());

            UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);
            logger.info("JWT generated for username: {}", authRequest.getUsername());

            return ResponseEntity.ok(new AuthenticationResponse(jwt));

        } catch (BadCredentialsException e) {
            logger.error("Invalid username or password for username: {}", authRequest.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        } catch (UsernameNotFoundException e) {
            logger.error("User not found: {}", authRequest.getUsername());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (Exception e) {
            logger.error("An error occurred during login for username: {}", authRequest.getUsername(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}


