package com.canse.teacher.service;

import com.canse.teacher.dto.TeacherDto;
import com.canse.teacher.entities.Teacher;
import com.canse.teacher.repos.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();

        return new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName()
        );
    }
}
