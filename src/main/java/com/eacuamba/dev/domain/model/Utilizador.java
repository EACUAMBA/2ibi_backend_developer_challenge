package com.eacuamba.dev.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "utilizador")
public class Utilizador implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilizador_seq")
    private Long id;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utilizador_utilizador_authority",
            joinColumns = @JoinColumn(name = "utilizador_id"),
            inverseJoinColumns = @JoinColumn(name = "utilizador_authority_id")
    )
    private Set<UtilizadorAuthority> utilizadorAuthoritySet;
    private String password;
    private String username;
    private Boolean accountNonExpired;
    private Boolean accountNonLocked;
    private Boolean credentialsNonExpired;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.utilizadorAuthoritySet;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
