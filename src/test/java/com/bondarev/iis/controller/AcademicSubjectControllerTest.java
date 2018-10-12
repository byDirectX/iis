package com.bondarev.iis.controller;

import com.bondarev.iis.model.AcademicSubject;
import com.bondarev.iis.service.AcademicSubjectService;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AcademicSubjectControllerTest {

    @Mock
    private AcademicSubjectService academicSubjectService;

    @InjectMocks
    AcademicSubjectController academicSubjectController;

    @Test
    public void mainAcademicSubject() {
        when(academicSubjectService.getListAcademicSubject()).thenReturn(ImmutableList.of());
    }

    @Test
    public void editAcademicSubject() {
        when(academicSubjectService.getAcademicSubjectById(0)).thenReturn(new AcademicSubject());
    }
}