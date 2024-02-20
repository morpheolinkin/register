package com.api.register.controller.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
public class StandardError implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private LocalDate localDate;

    public StandardError(Integer status, String msg, LocalDate localDate){
        this.status = status;
        this.msg = msg;
        this.localDate = localDate;
    }
}
