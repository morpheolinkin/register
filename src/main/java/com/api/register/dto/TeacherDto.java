package com.api.register.dto;

import com.api.register.domain.Student;
import com.api.register.domain.Teacher;
import com.api.register.enums.Sex;

import java.time.LocalDate;

public record TeacherDto
        (Integer id, String name, LocalDate age,
         Sex sex, String address, String cpf) {
    public TeacherDto(Teacher obj){
        this(
                obj.getId(),
                obj.getName(),
                obj.getAge(),
                obj.getSex(),
                obj.getAddress(),
                obj.getCpf());
    }
}
