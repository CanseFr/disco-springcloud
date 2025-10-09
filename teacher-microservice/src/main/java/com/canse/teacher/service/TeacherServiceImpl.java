package com.canse.teacher.service;

import com.canse.teacher.dto.ApiResponseDto;
import com.canse.teacher.dto.DepartmentDto;
import com.canse.teacher.dto.TeacherDto;
import com.canse.teacher.entities.Teacher;
import com.canse.teacher.repos.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;
    private APIClient apiClient;

    @Override
    public ApiResponseDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(teacher.getDepCode());

         TeacherDto teacherDto = new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getDepCode(),
                 departmentDto.getDepName()
        );

         ApiResponseDto apiResponseDto = new ApiResponseDto();
         apiResponseDto.setTeacherDto(teacherDto);
         apiResponseDto.setDepartmentDto(departmentDto);
         return apiResponseDto;
    }
}

