package com.SpringDemo.Controller;

import com.SpringDemo.Exceptions.CustomResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<?> sayHello( @AuthenticationPrincipal OAuth2User principal, @AuthenticationPrincipal OidcUser oidcUser) {

        return ResponseEntity.ok(new CustomResponse("200",
                "success"
        ,"Hello, World! " +
                "OIDC User: " + oidcUser.getIdToken().getTokenValue() + "\n"
//                "OAuth2 User: " + principal.getAttributes()
                ));
    }

}

