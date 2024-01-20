package com.api.register.domain;

import com.api.register.enums.Sex;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter @Setter @ToString
@NoArgsConstructor @Entity @Builder
@AllArgsConstructor @Table(name = "tb_student")
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name is required")
    private String name;
    private LocalDate age;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String responsible;
    private String address;
    @CPF
    private String cpf;
    private String rg;
    private String birthCertificate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
