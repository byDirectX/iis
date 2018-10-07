package com.bondarev.shedulesubsystem.service;

import com.bondarev.shedulesubsystem.model.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> getListTeacher();

    public void addTeacher(Teacher teacher);

    public void updateTeacher(Teacher teacher);

    public Teacher getTeacherById(int id);

    public void removeTeacher(int id);

}
