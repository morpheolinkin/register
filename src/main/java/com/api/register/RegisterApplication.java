package com.api.register;

import com.api.register.domain.Student;
import com.api.register.repository.StudentRepository;
import com.api.register.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;

import static java.util.Arrays.asList;

@SpringBootApplication
@RequiredArgsConstructor
public class RegisterApplication implements CommandLineRunner {
    //private final StudentRepository studentRepository;
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* Student student = new Student();
        student.setName("Edivania Paixão");
        student.setAddress("Rua José Genario");
        student.setSex("Feminino");
        student.setAge(DateUtil.parseDateTime("26/09/1986"));
        student.setResponsible("Maria Eugênia e Osmar de Souza");

        studentRepository.save(student);*/
    }
}
