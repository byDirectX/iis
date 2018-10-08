package com.bondarev.iis.dao;

import com.bondarev.iis.model.AcademicSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicSubjectDao extends JpaRepository<AcademicSubject, Integer> {

}
