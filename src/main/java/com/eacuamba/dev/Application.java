package com.eacuamba.dev;

import com.eacuamba.dev.domain.model.Regiao;
import com.eacuamba.dev.domain.repository.PaisRepository;
import com.eacuamba.dev.domain.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
