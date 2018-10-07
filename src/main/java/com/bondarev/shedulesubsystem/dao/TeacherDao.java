package com.bondarev.shedulesubsystem.dao;

import com.bondarev.shedulesubsystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
