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
@Table(name = "subregiao")
public class SubRegiao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subregiao_seq")
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "subRegiao")
    private Set<Pais> paisSet;
}
