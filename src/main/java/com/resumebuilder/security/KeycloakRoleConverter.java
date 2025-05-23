package com.resumebuilder.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
        if (resourceAccess == null || !resourceAccess.containsKey("springboot-client")) {
            return List.of();
        }

        Map<String, Object> springbootClient = (Map<String, Object>) resourceAccess.get("springboot-client");
        List<String> roles = (List<String>) springbootClient.get("roles");

        return roles.stream()
                .map(role -> "ROLE_" + role.toUpperCase()) // Prefix with ROLE_ (optional)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
