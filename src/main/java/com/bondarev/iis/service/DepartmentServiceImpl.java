package com.bondarev.iis.service;

import com.bondarev.iis.dao.DepartmentDao;
import com.bondarev.iis.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public List<Department> getListDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public void addDepartment(Department department) {
        departmentDao.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDao.saveAndFlush(department);
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDao.getOne(id);
    }

    @Override
    public void removeDepartment(int id) {
        departmentDao.deleteById(id);
    }
}
