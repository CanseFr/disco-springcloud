package com.canse.teacher.repos;

import com.canse.teacher.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
