package com.eacuamba.dev.domain.repository;

import com.eacuamba.dev.domain.model.SubRegiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubRegiaoRepository extends JpaRepository<SubRegiao, Long> {
    public List<SubRegiao> findByNomeEquals(String nome);
}
