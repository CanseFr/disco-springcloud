package org.canse.departmentmicroservice.service;

import lombok.AllArgsConstructor;
import org.canse.departmentmicroservice.dto.DepartmentDto;
import org.canse.departmentmicroservice.entities.Department;
import org.canse.departmentmicroservice.repos.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto getDepartmentByCode(String code){
        Department dep = departmentRepository.findByDepCode(code);
        DepartmentDto departmentDto = new DepartmentDto(
                dep.getId(),
                dep.getDepName(),
                dep.getDepCode()
        );
        return departmentDto;
    }

}
