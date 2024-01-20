package com.api.register.controller;

import com.api.register.domain.Student;
import com.api.register.dto.StudentDto;
import com.api.register.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> list(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> listAll() {
        List<Student> obj = studentService.listAll();
        List<StudentDto> dtoList = obj.stream().map(StudentDto::new).toList();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDto studentDto) {
        Student newStudent = studentService.convertFromDTO(studentDto);
        studentService.save(newStudent);
        URI newStudentUri = studentService.buildNewStudentUri(studentDto);
        return ResponseEntity.created(newStudentUri).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@RequestBody StudentDto obj, @PathVariable Integer id) {
        Student student = studentService.convertFromDTO(obj);
        student.setId(id);
        studentService.update(student);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<StudentDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Student> list = studentService.findPage(page, linesPerPage, orderBy, direction);
        Page<StudentDto> listDto = list.map(StudentDto::new);
        return ResponseEntity.ok().body(listDto);
    }
}
