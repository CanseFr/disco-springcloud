package org.canse.departmentmicroservice.restControllers;

import lombok.AllArgsConstructor;
import org.canse.departmentmicroservice.dto.DepartmentDto;
import org.canse.departmentmicroservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
        return new ResponseEntity<DepartmentDto>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }

}
