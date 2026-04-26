package org.luis.proyecto.infrastructure.config;

import io.jsonwebtoken.Jwts;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class JwtAuthenticationConfig {
    public String getJwtToken(String username) {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .subject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
                .signWith(getSigningKey(SUPER_SECRET_KEY), Jwts.SIG.HS256).compact();
        return "Bearer " + token;
    }
}
