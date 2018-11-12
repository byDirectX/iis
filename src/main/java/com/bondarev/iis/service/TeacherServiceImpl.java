package com.bondarev.iis.service;

import com.bondarev.iis.model.Teacher;
import com.bondarev.iis.dao.TeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;


    @Override
    public List<Teacher> getListTeacher() {
        return teacherDao.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherDao.saveAndFlush(teacher);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherDao.getOne(id);
    }

    @Override
    public void removeTeacher(int id) {
        teacherDao.deleteById(id);
    }

}
