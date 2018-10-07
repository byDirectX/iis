package com.bondarev.shedulesubsystem.service;

import com.bondarev.shedulesubsystem.model.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getListDepartment();

    public void addDepartment(Department department);

    public void updateDepartment(Department department);

    public Department getDepartmentById(int id);

    public void removeDepartment(int id);

}