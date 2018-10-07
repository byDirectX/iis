package com.bondarev.shedulesubsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "id_group")
    private int groupId;

    @Column(name = "id_academic_subject")
    private int academicSubjectId;

    @Column(name = "id_substitution_academic_subject")
    private int substitutionAcademicSubjectId;

    @Column(name = "id_first_teacher")
    private int firstTeacherId;

    @Column(name = "id_second_teacher")
    private int secondTeacherId;

    @Column(name = "id_time")
    private int timeId;

    @Column(name = "flag")
    private int flag;

    @Column(name = "id_day")
    private int dayId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getAcademicSubjectId() {
        return academicSubjectId;
    }

    public void setAcademicSubjectId(int academicSubjectId) {
        this.academicSubjectId = academicSubjectId;
    }

    public int getSubstitutionAcademicSubjectId() {
        return substitutionAcademicSubjectId;
    }

    public void setSubstitutionAcademicSubjectId(int substitutionAcademicSubjectId) {
        this.substitutionAcademicSubjectId = substitutionAcademicSubjectId;
    }

    public int getFirstTeacherId() {
        return firstTeacherId;
    }

    public void setFirstTeacherId(int firstTeacherId) {
        this.firstTeacherId = firstTeacherId;
    }

    public int getSecondTeacherId() {
        return secondTeacherId;
    }

    public void setSecondTeacherId(int secondTeacherId) {
        this.secondTeacherId = secondTeacherId;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }
}
