package com.eacuamba.dev.endpoint.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExceptionBody {
    private int status;
    private LocalDateTime data;
    private String titulo;
}
