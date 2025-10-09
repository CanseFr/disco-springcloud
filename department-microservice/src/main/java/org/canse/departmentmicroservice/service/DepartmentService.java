package org.canse.departmentmicroservice.service;

import org.canse.departmentmicroservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto getDepartmentByCode(String code);
}
