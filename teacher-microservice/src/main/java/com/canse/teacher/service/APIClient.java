package com.canse.teacher.service;

import com.canse.teacher.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Maintenant que nous utilison Eureka, il n'est plus necessaire de preciser une url car le nom du service est enregistré pour chaque instance du service
//@FeignClient(url = "http://localhost:8080" , value = "DEPARTMENT-MICROSERVICE")
@FeignClient(value = "DEPARTMENT-MICROSERVICE")
public interface APIClient {

    @GetMapping("api/departments/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String departmentCode);

}
