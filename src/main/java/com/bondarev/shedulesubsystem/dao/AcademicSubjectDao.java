package com.bondarev.shedulesubsystem.dao;

import com.bondarev.shedulesubsystem.model.AcademicSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicSubjectDao extends JpaRepository<AcademicSubject, Integer> {

}
