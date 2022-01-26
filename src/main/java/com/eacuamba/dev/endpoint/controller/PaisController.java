package com.eacuamba.dev.endpoint.controller;

import com.eacuamba.dev.domain.model.Pais;
import com.eacuamba.dev.domain.repository.PaisRepository;
import com.eacuamba.dev.domain.service.PaisService;
import com.eacuamba.dev.endpoint.dto.PaisDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/pais")
public class PaisController {
    private PaisService paisService;

    @GetMapping
    public List<PaisDTO> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer pagesize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String dir
    ){

        return paisService.findAllAsDTOModels(page, pagesize, sortBy, dir.toUpperCase());
    }

    @GetMapping(path = "/{paisId}")
    public PaisDTO findById(@PathVariable("paisId") Long paisId){
        return paisService.findById(paisId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaisDTO save(@RequestBody PaisDTO paisDTO){
        return this.paisService.saveDTOModel(paisDTO);
    }

    @PutMapping(path = "/{paisId}")
    public void update(@PathVariable("paisId") Long paisId,  @RequestBody PaisDTO paisDTO){
        paisDTO.setId(paisId);
        this.paisService.updateDTOModel(paisDTO);
    }

    @DeleteMapping(path = "/{paisId}")
    public void delete(@PathVariable("paisId") Long paisId){
        this.paisService.delete(paisId);
    }
}
