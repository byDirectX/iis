package com.bondarev.shedulesubsystem.service;

import com.bondarev.shedulesubsystem.dao.GroupAcademicSubjectDao;
import com.bondarev.shedulesubsystem.model.GroupAcademicSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupAcademicSubjectServiceImpl implements GroupAcademicSubjectService {

    @Autowired
    private GroupAcademicSubjectDao groupAcademicSubjectDao;


    @Override
    public List<GroupAcademicSubject> getListGroupAcademicSubject() {
        return groupAcademicSubjectDao.findAll();
    }

    @Override
    public void addGroupAcademicSubject(GroupAcademicSubject groupAcademicSubject) {
        if (groupAcademicSubject.getId() == 0) {
            groupAcademicSubjectDao.save(groupAcademicSubject);
        } else {
            groupAcademicSubjectDao.saveAndFlush(groupAcademicSubject);
        }
    }

    @Override
    public void updateGroupAcademicSubject(GroupAcademicSubject groupAcademicSubject) {
        groupAcademicSubjectDao.saveAndFlush(groupAcademicSubject);
    }

    @Override
    public GroupAcademicSubject getGroupAcademicSubjectById(int id) {
        return groupAcademicSubjectDao.getOne(id);
    }

    @Override
    public void removeGroupAcademicSubject(int id) {
        groupAcademicSubjectDao.deleteById(id);
    }
}