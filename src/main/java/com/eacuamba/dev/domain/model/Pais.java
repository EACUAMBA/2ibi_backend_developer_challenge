package com.eacuamba.dev.domain.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pais_seq")
    private Long id;
    private String nome;
    private String capital;

    @ManyToOne()
    private Regiao regiao;

    @ManyToOne()
    private SubRegiao subRegiao;
    private Double area;


}
