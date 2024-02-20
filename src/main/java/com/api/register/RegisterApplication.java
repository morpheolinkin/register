package com.api.register;

import com.api.register.domain.Student;
import com.api.register.enums.Sex;
import com.api.register.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class RegisterApplication implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Student student = Student.builder()
                .name("João")
                .age(LocalDate.now())
                .age(LocalDate.now())
                .sex(Sex.FEMININO)
                .responsible("Maria")
                .address("Rua 1")
                .cpf("02893141510")
                .rg("123456789")
                .birthCertificate("123456789")
                .build();

        studentRepository.save(student);
    }
}
