package com.eacuamba.dev.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@Entity
@Table(name = "utilizador_authority")
public class UtilizadorAuthority implements GrantedAuthority {
    @JsonIgnore()
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilizador_authority_seq")
    private Long id;
    private String authority;

    @JsonIgnore()
    @ManyToMany(mappedBy = "utilizadorAuthoritySet", fetch = FetchType.EAGER)
    private Set<Utilizador> utilizadorSet;


    @Override
    public String getAuthority() {
       return authority;
    }
}
