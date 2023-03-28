package com.api.register.controller;

import com.api.register.domain.Student;
import com.api.register.dto.StudentDto;
import com.api.register.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping(path = "/{id}")
    public ResponseEntity<Student> list (@PathVariable Integer id){
       return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> listAll(){
        List<Student> obj = studentService.listAll();
        List<StudentDto> dtoList = obj.stream().map(StudentDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping
    public ResponseEntity<Student> insert(@Valid @RequestBody StudentDto dto){
        var obj = studentService.fromDTO(dto);
        studentService.save(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
