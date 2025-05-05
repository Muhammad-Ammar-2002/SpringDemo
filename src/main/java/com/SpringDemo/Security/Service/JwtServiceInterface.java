package com.SpringDemo.Security.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServiceInterface {

    String generateToken(String username);

    String extractUsername(String token);

    boolean validateToken(String jwtToken, UserDetails userDetails);


    ;
}
