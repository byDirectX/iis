package com.bondarev.shedulesubsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "study_group_academic_subject")
public class GroupAcademicSubject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_study_group")
    private int studyGroupId;

    @Column(name = "id_academic_subject")
    private int academicSubjectId;

    @Column(name = "number_hours")
    private int number_hours;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(int studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public int getAcademicSubjectId() {
        return academicSubjectId;
    }

    public void setAcademicSubjectId(int academicSubjectId) {
        this.academicSubjectId = academicSubjectId;
    }

    public int getNumber_hours() {
        return number_hours;
    }

    public void setNumber_hours(int number_hours) {
        this.number_hours = number_hours;
    }
}
