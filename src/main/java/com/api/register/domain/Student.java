package com.api.register.domain;

import com.api.register.enums.Sex;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor @Entity
@Table(name = "tb_student")
public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @ManyToMany
    @JoinTable(
            name = "STUDENT_DISCIPLINA",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas;

    @Builder
    private Student(Long id, String name, LocalDate age, Sex sex, String responsible,
                    String address, String cpf, String rg, String birthCertificate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.responsible = responsible;
        this.address = address;
        this.cpf = cpf;
        this.rg = rg;
        this.birthCertificate = birthCertificate;
    }

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
