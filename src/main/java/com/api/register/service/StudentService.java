package com.api.register.service;

import com.api.register.domain.Student;
import com.api.register.dto.StudentDto;
import com.api.register.dto.StudentResponseDto;
import com.api.register.repository.StudentRepository;
import com.api.register.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentResponseDto findById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException
                        ("Student not found! Id: " + id + ", Type: " + Student.class.getName()));
        //No corpo da requisição será retornado um objeto personalizado com os dados do aluno contendo apenas os dados que eu quero
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getCpf(),
                student.getTurma(),
                student.getDisciplinas()
        );
    }
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public void save(Student obj) {
        obj.setId(null);
        studentRepository.save(obj);
    }

    public Student convertFromDTO(StudentDto dto) {
        return Student.builder()
                .id(dto.id())
                .name(dto.name())
                .age(dto.age())
                .sex(dto.sex())
                .responsible(dto.responsible())
                .address(dto.address())
                .cpf(dto.cpf())
                .rg(dto.rg())
                .birthCertificate(dto.birthCertificate())
                .build();
    }

    public Student findStudentById(Long id) {
    return studentRepository.findById(id)
            .orElseThrow(() -> new ObjectNotFoundException
                    ("Student not found! Id: " + id + ", Type: " + Student.class.getName()));
}

public void delete(Long id) {
    studentRepository.delete(findStudentById(id));
}

public void update(Student student) {
    var studentUpdate = findStudentById(student.getId());
    upadateData(studentUpdate, student);
    studentRepository.save(studentUpdate);
}

    private void upadateData(Student studentUpdate, Student student) {
        studentUpdate.setName(student.getName());
        studentUpdate.setAge(student.getAge());
        studentUpdate.setSex(student.getSex());
        studentUpdate.setResponsible(student.getResponsible());
        studentUpdate.setAddress(student.getAddress());
    }

    public Page<Student> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return studentRepository.findAll(pageRequest);
    }

    public URI buildNewStudentUri(StudentDto studentDto) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(studentDto.id())
                .toUri();
    }
}
