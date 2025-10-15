package com.canse.teacher.restControllers;

import com.canse.teacher.config.Configuration;
import com.canse.teacher.dto.ApiResponseDto;
import com.canse.teacher.dto.TeacherDto;
import com.canse.teacher.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers")
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    Configuration configuration;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDto> getTeacherById(@PathVariable("id") Long id) {
        return new ResponseEntity<ApiResponseDto>(teacherService.getTeacherById(id), HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(configuration.getName() + " " + configuration.getEmail());
    }


}
