package com.api.register.service;

import com.api.register.domain.Teacher;
import com.api.register.dto.TeacherDto;
import com.api.register.repository.TeacherRepository;
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
public class TeacherService {
    private final TeacherRepository teacherRepository;


    public Teacher findById(Integer id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException
                        (HttpStatus.BAD_REQUEST, "Teacher not found"));
    }
    public List<Teacher> listAll() {
        return teacherRepository.findAll();
    }

    public void save(Teacher obj) {
        obj.setId(null);
        teacherRepository.save(obj);
    }

    public Teacher convertFromDTO(TeacherDto dto) {
        return new Teacher(dto.id(), dto.name(),
                dto.age(), dto.sex(),
                dto.address(), dto.cpf());
    }

    public void delete(Integer id) {
        teacherRepository.delete(findById(id));
    }

    public void update(Teacher Teacher) {
        var teacherUpdate = findById(Teacher.getId());
        upadateData(teacherUpdate, Teacher);
        teacherRepository.save(teacherUpdate);
    }

    private void upadateData(Teacher teacherUpdate, Teacher teacher) {
        teacherUpdate.setName(teacher.getName());
        teacherUpdate.setAge(teacher.getAge());
        teacherUpdate.setSex(teacher.getSex());
        teacherUpdate.setAddress(teacher.getAddress());
    }

    public Page<Teacher> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return teacherRepository.findAll(pageRequest);
    }

    public URI buildNewTeacherUri(TeacherDto teacherDto) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(teacherDto.id())
                .toUri();
    }
}
