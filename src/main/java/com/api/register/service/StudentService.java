package com.api.register.service;

import com.api.register.domain.Student;
import com.api.register.dto.StudentDto;
import com.api.register.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    public void save(Student obj) {
        obj.setId(null);
        studentRepository.save(obj);
    }

    public Student convertFromDTO(StudentDto dto) {
        return new Student(dto.id(), dto.name(),
                dto.age(), dto.sex(), dto.responsible(),
                dto.address(), dto.cpf(), dto.rg(), dto.birthCertificate());
    }

    public void delete(Integer id) {
        studentRepository.delete(findById(id));
    }

    public void update(Student student) {
        var studentUpdate = findById(student.getId());
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
