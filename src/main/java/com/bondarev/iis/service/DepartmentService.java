package com.bondarev.iis.service;

import com.bondarev.iis.model.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> getListDepartment();

    public void addDepartment(Department department);

    public void updateDepartment(Department department);

    public Department getDepartmentById(int id);

    public void removeDepartment(int id);

}