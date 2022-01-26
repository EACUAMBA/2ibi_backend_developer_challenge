package com.eacuamba.dev.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String capital;
    private String regiaoNome;
    private String subRegiaoNome;
    private Double area;
}
