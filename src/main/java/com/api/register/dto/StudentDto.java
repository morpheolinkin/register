package com.api.register.dto;

import com.api.register.domain.Student;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.api.register.domain.Student} entity
 */

@Getter
@Setter
public class StudentDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private LocalDate age;
    private String sex;
    private String responsible;
    private String address;

    public StudentDto() {
    }

    public StudentDto(Student obj){
        this.id = obj.getId();
        this.name = obj.getName();
        this.age = obj.getAge();
        this.sex = obj.getSex();
        this.responsible = obj.getResponsible();
        this.address = obj.getAddress();
    }
}