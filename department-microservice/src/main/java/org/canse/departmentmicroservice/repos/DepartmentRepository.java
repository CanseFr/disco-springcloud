package org.canse.departmentmicroservice.repos;

import org.canse.departmentmicroservice.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepCode(String code);
}
