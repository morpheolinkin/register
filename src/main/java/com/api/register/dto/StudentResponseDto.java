package com.api.register.dto;

import com.api.register.domain.Disciplina;
import com.api.register.domain.Turma;

import java.util.List;

public record StudentResponseDto(
        Long id,
        String name,
        String cpf,
        Turma turma,
        List<Disciplina> disciplinas
) {
}
