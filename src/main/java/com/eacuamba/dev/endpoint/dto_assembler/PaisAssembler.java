package com.eacuamba.dev.endpoint.dto_assembler;

import com.eacuamba.dev.domain.model.Pais;
import com.eacuamba.dev.endpoint.dto.PaisDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PaisAssembler {
    private final ModelMapper modelMapper;

    public PaisDTO toPaisDTO(Pais pais){
        if(pais == null) return null;
        return this.modelMapper.map(pais, PaisDTO.class);
    }
    public List<PaisDTO> toDTOCollection(List<Pais> paisList){
        return paisList.stream()
                .map((pais)->{return this.toPaisDTO(pais);})
                .collect(Collectors.toList());
    }

    public Pais toPaisDomainModel(PaisDTO paisDTO){
        if(paisDTO == null) return null;
        return this.modelMapper.map(paisDTO, Pais.class);
    }

}
