package com.bondarev.iis.service;

import com.bondarev.iis.dao.AcademicSubjectDao;
import com.bondarev.iis.model.AcademicSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicSubjectServiceImpl implements AcademicSubjectService {

    @Autowired
    private AcademicSubjectDao academicSubjectDao;


    @Override
    public List<AcademicSubject> getListAcademicSubject() {
        return academicSubjectDao.findAll();
    }

    @Override
    public void addAcademicSubject(AcademicSubject academicSubject) {
        academicSubjectDao.save(academicSubject);
    }

    @Override
    public void updateAcademicSubject(AcademicSubject academicSubject) {
        academicSubjectDao.saveAndFlush(academicSubject);
    }

    @Override
    public AcademicSubject getAcademicSubjectById(int id) {
        return academicSubjectDao.getOne(id);
    }

    @Override
    public void removeAcademicSubject(int id) {
        academicSubjectDao.deleteById(id);
    }
}
