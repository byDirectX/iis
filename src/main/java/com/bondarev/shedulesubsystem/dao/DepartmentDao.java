package com.bondarev.shedulesubsystem.dao;

import com.bondarev.shedulesubsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
