package com.eacuamba.dev.domain.repository;

import com.eacuamba.dev.domain.model.Utilizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UtilizadorRepository extends JpaRepository<Utilizador, Long> {
    Utilizador findByUsername(String username);
}
