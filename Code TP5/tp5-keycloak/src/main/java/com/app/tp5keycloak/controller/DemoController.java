package com.app.tp5keycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    // Réservé aux utilisateurs qui ont le rôle client_user (user1)
    @PreAuthorize("hasRole('client_user')")
    @GetMapping("/hello")
    public String helloUser() {
        return "Hello from Spring boot & Keycloak";
    }

    // Réservé aux utilisateurs qui ont le rôle client_admin (admin)
    @PreAuthorize("hasRole('client_admin')")
    @GetMapping("/helloadmin")
    public String helloAdmin() {
        return "Hello Admin from Spring boot & Keycloak";
    }

    // Ouvert à tout utilisateur connecté : renvoie l'utilisateur et ses autorités
    @GetMapping("/profile")
    public Authentication profile(Authentication authentication) {
        return authentication;
    }
}