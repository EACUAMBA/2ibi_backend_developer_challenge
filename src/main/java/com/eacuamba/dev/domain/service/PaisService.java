package com.eacuamba.dev.domain.service;

import com.eacuamba.dev.domain.model.Pais;
import com.eacuamba.dev.domain.model.Regiao;
import com.eacuamba.dev.domain.model.SubRegiao;
import com.eacuamba.dev.domain.repository.PaisRepository;
import com.eacuamba.dev.domain.repository.RegiaoRepository;
import com.eacuamba.dev.domain.repository.SubRegiaoRepository;
import com.eacuamba.dev.endpoint.dto.PaisDTO;
import com.eacuamba.dev.endpoint.dto_assembler.PaisAssembler;
import com.eacuamba.dev.endpoint.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PaisService {
    private final PaisRepository paisRepository;
    private final PaisAssembler paisAssembler;
    private final RegiaoRepository regiaoRepository;
    private final SubRegiaoRepository subRegiaoRepository;

    public List<Pais> findAll() {
        return this.paisRepository.findAll();
    }

    public List<PaisDTO> findAllAsDTOModels() {
        return this.paisAssembler.toDTOCollection(this.findAll());
    }

    public PaisDTO saveDTOModel(PaisDTO paisDTO) {
        Pais pais = this.paisAssembler.toPaisDomainModel(paisDTO);
        verificaRegiao(pais);
        verificaSubRegiao(pais);
        this.paisRepository.save(pais);
        return this.paisAssembler.toPaisDTO(pais);
    }

    public PaisDTO updateDTOModel(PaisDTO paisDTO) {
        Optional<Pais> paisOptional = this.paisRepository.findById(paisDTO.getId());
        if (!paisOptional.isPresent()) {
            throw new EntidadeNaoEncontradaException(String.format("Não encontramos nenhum pais com esse id %s para actualizar.", paisDTO.getId()));
        }
        Pais pais = this.paisAssembler.toPaisDomainModel(paisDTO);
        verificaRegiao(pais);
        verificaSubRegiao(pais);
        this.paisRepository.save(pais);
        return this.paisAssembler.toPaisDTO(pais);
    }


    public void delete(Long paisId) {
        Optional<Pais> paisOptional = this.paisRepository.findById(paisId);
        if (!paisOptional.isPresent()) {
            throw new EntidadeNaoEncontradaException(String.format("Não encontramos nenhum pais com esse id %s para eliminar.", paisId));
        }
        this.paisRepository.delete(paisOptional.get());
    }

    public PaisDTO findById(Long paisId) {
        Optional<Pais> paisOptional = this.paisRepository.findById(paisId);
        if (!paisOptional.isPresent()) {
            throw new EntidadeNaoEncontradaException(String.format("Não encontramos nenhum pais com esse id %s", paisId));
        }
        return this.paisAssembler.toPaisDTO(paisOptional.get());
    }

    public void verificaRegiao(Pais pais) {
        List<Regiao> regiaoList = regiaoRepository.findByNomeEquals(pais.getRegiao().getNome());
        if (!regiaoList.isEmpty()) {
            pais.setRegiao(regiaoList.get(0));
        } else {
            this.regiaoRepository.save(pais.getRegiao());
        }
    }

    public void verificaSubRegiao(Pais pais) {
        List<SubRegiao> subRegiaoList = subRegiaoRepository.findByNomeEquals(pais.getSubRegiao().getNome());
        if (!subRegiaoList.isEmpty()) {
            pais.setSubRegiao(subRegiaoList.get(0));
        } else
            this.subRegiaoRepository.save(pais.getSubRegiao());
    }

    public List<PaisDTO> findAllAsDTOModels(Integer page, Integer pagesize, String sortBy, String dir) {
        String finalDir = dir;
        List<String> directions = Arrays.asList(Sort.Direction.values()).stream().map(Sort.Direction::name).filter((direction -> direction.equalsIgnoreCase(finalDir))).collect(Collectors.toList());

        if(directions.isEmpty()){
            dir= Sort.Direction.ASC.name();
        }else{
            dir = directions.get(0).toUpperCase();
        }



        Pageable pageable = PageRequest.of(page, pagesize, Sort.by(Sort.Direction.valueOf(dir), sortBy));

        Page<Pais> pageResult = this.paisRepository.findAll(pageable);

        if(pageResult.hasContent()){
            return pageResult.getContent().stream().map(this.paisAssembler::toPaisDTO).collect(Collectors.toList());
        }else{
            return new ArrayList<>();
        }
    }
}
