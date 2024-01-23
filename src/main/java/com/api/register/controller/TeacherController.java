package com.api.register.controller;

import com.api.register.domain.Teacher;
import com.api.register.dto.TeacherDto;
import com.api.register.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Teacher> list(@PathVariable Integer id) {
        return ResponseEntity.ok(teacherService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<TeacherDto>> listAll() {
        List<Teacher> obj = teacherService.listAll();
        List<TeacherDto> dtoList = obj.stream().map(TeacherDto::new).toList();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@Valid @RequestBody TeacherDto teacherDto) {
        Teacher newTeacher = teacherService.convertFromDTO(teacherDto);
        teacherService.save(newTeacher);
        URI newTeacherUri = teacherService.buildNewTeacherUri(teacherDto);
        return ResponseEntity.created(newTeacherUri).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        teacherService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> update(@RequestBody TeacherDto obj, @PathVariable Integer id) {
        Teacher teacher = teacherService.convertFromDTO(obj);
        teacher.setId(id);
        teacherService.update(teacher);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/page")
    public ResponseEntity<Page<TeacherDto>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<Teacher> list = teacherService.findPage(page, linesPerPage, orderBy, direction);
        Page<TeacherDto> listDto = list.map(TeacherDto::new);
        return ResponseEntity.ok().body(listDto);
    }
}
