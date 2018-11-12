package com.bondarev.iis.service;

import com.bondarev.iis.model.AcademicSubject;

import java.util.List;

public interface AcademicSubjectService {

    public List<AcademicSubject> getListAcademicSubject();

    public void addAcademicSubject(AcademicSubject academicSubject);

    public void updateAcademicSubject(AcademicSubject academicSubject);

    public AcademicSubject getAcademicSubjectById(int id);

    public void removeAcademicSubject(int id);

}
