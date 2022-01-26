package com.eacuamba.dev.security.configuration;

import com.eacuamba.dev.domain.service.UtilizadorService;
import com.eacuamba.dev.security.filters.JwtTokenVerify;
import com.eacuamba.dev.security.filters.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final UtilizadorService utilizadorService;
    private final JwtConfig jwtConfig;
    private final JwtSecreteKey jwtSecreteKey;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, UtilizadorService utilizadorService, JwtConfig jwtConfig, JwtSecreteKey jwtSecreteKey) {
        this.passwordEncoder = passwordEncoder;
        this.utilizadorService = utilizadorService;
        this.jwtConfig = jwtConfig;
        this.jwtSecreteKey = jwtSecreteKey;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //Desabilitando a proteção CSRF
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Desabilitando a criação de sessões, tornando a aplicação sem estado-
        .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(this.authenticationManager(), jwtConfig, jwtSecreteKey))
                .addFilterAfter(new JwtTokenVerify(this.jwtSecreteKey, this.jwtConfig), JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/pais/**").permitAll()
                .antMatchers("/api/paises/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated();
    }

}
