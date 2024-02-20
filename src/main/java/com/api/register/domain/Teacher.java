package com.api.register.domain;

import com.api.register.enums.Sex;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor @Entity
@Table(name = "tb_teacher")
public class Teacher implements Serializable {
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
    private String address;
    @CPF
    private String cpf;

    @ManyToMany
    @JoinTable(
            name = "teacher_turma",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "turma_id")
    )
    @JsonManagedReference
    @ToString.Exclude
    private List<Turma> turmas;

    @ManyToMany
    @JoinTable(
            name = "TEACHER_DISCIPLINA",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    @JsonManagedReference
    private List<Disciplina> disciplinas;

    public Teacher(Integer id, String name, LocalDate age,
                   Sex sex, String address, String cpf) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher student = (Teacher) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
