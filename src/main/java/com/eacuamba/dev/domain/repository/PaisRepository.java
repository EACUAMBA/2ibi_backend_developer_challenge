package com.eacuamba.dev.domain.repository;

import com.eacuamba.dev.domain.model.Pais;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    public Page<Pais> findAll(Pageable pageable);
}
