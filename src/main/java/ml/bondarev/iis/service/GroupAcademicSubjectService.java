package ml.bondarev.iis.service;

import ml.bondarev.iis.model.GroupAcademicSubject;

import java.util.List;

public interface GroupAcademicSubjectService {

    public List<GroupAcademicSubject> getListGroupAcademicSubject();

    public void addGroupAcademicSubject(GroupAcademicSubject groupAcademicSubject);

    public void updateGroupAcademicSubject(GroupAcademicSubject groupAcademicSubject);

    public GroupAcademicSubject getGroupAcademicSubjectById(int id);

    public void removeGroupAcademicSubject(int id);

}
