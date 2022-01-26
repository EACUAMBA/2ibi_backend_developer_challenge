package com.eacuamba.dev.domain.repository;

import com.eacuamba.dev.domain.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
    public List<Regiao> findByNomeEquals(String nome);
}
