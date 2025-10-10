package org.canse.departmentmicroservice.restControllers;

import lombok.AllArgsConstructor;
import org.canse.departmentmicroservice.config.Configuration;
import org.canse.departmentmicroservice.dto.DepartmentDto;
import org.canse.departmentmicroservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    Configuration configuration;

    @Value("${build.version}")
    private String buildVersion;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
        return new ResponseEntity<DepartmentDto>(departmentService.getDepartmentByCode(code), HttpStatus.OK);
    }


    @GetMapping("/version")
    public ResponseEntity<String> version() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(configuration.getName() + " " + configuration.getEmail());
    }

}
