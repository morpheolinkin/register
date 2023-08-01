package com.api.register.dto;

import com.api.register.domain.Student;
import java.time.LocalDate;

public record StudentDto
        (Integer id, String name, LocalDate age,
         String sex, String responsible, String address) {
    public StudentDto(Student obj){
        this(obj.getId(), obj.getName(), obj.getAge(), obj.getSex(),
                obj.getResponsible(), obj.getAddress());
    }
}
