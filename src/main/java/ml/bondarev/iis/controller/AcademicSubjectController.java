package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.AcademicSubject;
import ml.bondarev.iis.service.AcademicSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcademicSubjectController {

    private static final Logger log = LoggerFactory.getLogger(AcademicSubjectController.class);

    @Autowired
    private AcademicSubjectService academicSubjectService;


    @RequestMapping(value = "/academicsubject", method = RequestMethod.GET)
    public List<AcademicSubject> getListAcademicSubjects() {
        return academicSubjectService.getListAcademicSubject();
    }

    @RequestMapping(value = "/academicsubject", method = RequestMethod.POST)
    public void addAcademicSubject(@ModelAttribute AcademicSubject academicSubject) {
        if (academicSubject.getId() == 0) {
            academicSubjectService.addAcademicSubject(academicSubject);
            log.info("Academic subject added successfully");
        } else {
            academicSubjectService.updateAcademicSubject(academicSubject);
            log.info("Academic subject update successfully");
        }
    }

    @RequestMapping(value = "/academicsubject/{id}", method = RequestMethod.DELETE)
    public void removeAcademicSubject(@PathVariable("id") int id) {
        academicSubjectService.removeAcademicSubject(id);

        log.info("Academic subject remove successfully");
    }

    @RequestMapping(value = "/academicsubject/{id}", method = RequestMethod.PUT)
    public AcademicSubject getOneAcademicSubject(@PathVariable("id") int id) {
        log.info("Academic subject for edit issued successfully");

        return academicSubjectService.getAcademicSubjectById(id);
    }
}
