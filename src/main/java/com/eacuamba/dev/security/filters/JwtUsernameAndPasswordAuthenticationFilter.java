package com.eacuamba.dev.security.filters;

import com.eacuamba.dev.security.configuration.JwtConfig;
import com.eacuamba.dev.security.configuration.JwtSecreteKey;
import com.eacuamba.dev.security.requests.UsernameAndPasswordAuthenticationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final JwtConfig jwtConfig;
    private final JwtSecreteKey jwtSecreteKey;
    private final AuthenticationManager authenticationManager;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig, JwtSecreteKey jwtSecreteKey) {
        super(authenticationManager);
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
        this.jwtSecreteKey = jwtSecreteKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try{
            UsernameAndPasswordAuthenticationRequest usernameAndPasswordAuthenticationRequest = new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    usernameAndPasswordAuthenticationRequest.getUsername(),
                    usernameAndPasswordAuthenticationRequest.getPassword()
            );

            return this.authenticationManager.authenticate(authentication);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(this.jwtConfig.getExpirationAfterDays())))
                .signWith(this.jwtSecreteKey.getSecurityKeyForSign())
                .compact();

        response.addHeader(this.jwtConfig.getAuthorizationHeader(), "Bearer " + token);
    }
}
