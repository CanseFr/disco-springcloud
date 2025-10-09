package com.canse.teacher.service;

import com.canse.teacher.dto.ApiResponseDto;
import com.canse.teacher.dto.TeacherDto;

public interface TeacherService {
    ApiResponseDto getTeacherById(Long id);
}
