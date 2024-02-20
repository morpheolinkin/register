package com.api.register.dto;

import com.api.register.domain.Student;
import com.api.register.enums.Sex;

import java.time.LocalDate;

public record StudentDto
        (Long id, String name, LocalDate age,
         Sex sex, String responsible, String address,
         String cpf, String rg, String birthCertificate) {
    public StudentDto(Student obj){
        this(obj.getId(), obj.getName(), obj.getAge(), obj.getSex(),
                obj.getResponsible(), obj.getAddress(),
                obj.getCpf(), obj.getRg(), obj.getBirthCertificate());
    }
}
