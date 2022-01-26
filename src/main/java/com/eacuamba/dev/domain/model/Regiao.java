package com.eacuamba.dev.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "regiao")
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regiao_seq")
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "regiao")
    private Set<Pais> paisSet;

}
