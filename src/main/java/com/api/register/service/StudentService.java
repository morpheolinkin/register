package com.api.register.service;

import com.api.register.domain.Student;
import com.api.register.dto.StudentDto;
import com.api.register.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;


    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.BAD_REQUEST, "Student not found"));
    }
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    public Student save(Student obj) {
        obj.setId(null);
        return studentRepository.save(obj);
    }

    public Student fromDTO(StudentDto dto) {
        return new Student(dto.getId(), dto.getName(),
                dto.getAge(), dto.getSex(), dto.getResponsible(),
                dto.getAddress());
    }
}
