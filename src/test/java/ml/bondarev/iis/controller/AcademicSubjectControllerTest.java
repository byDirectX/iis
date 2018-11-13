package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.AcademicSubject;
import ml.bondarev.iis.service.AcademicSubjectService;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
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