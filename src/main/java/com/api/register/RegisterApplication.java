package com.api.register;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
