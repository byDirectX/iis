package ml.bondarev.iis.restController;

import ml.bondarev.iis.model.GroupAcademicSubject;
import ml.bondarev.iis.service.GroupAcademicSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping(value = "/api")
public class RestGroupAcademicSubjectController {

    private static final Logger log = LoggerFactory.getLogger(RestGroupAcademicSubjectController.class);

    @Autowired
    private GroupAcademicSubjectService groupAcademicSubjectService;


    @RequestMapping(value = "/listofdisciplines", method = RequestMethod.GET)
    public List<GroupAcademicSubject> getListOfDisciplines() {
        return groupAcademicSubjectService.getListGroupAcademicSubject();
    }

    @RequestMapping(value = "/listofdisciplines", method = RequestMethod.POST)
    public void addDisciplinesOfList(@ModelAttribute GroupAcademicSubject groupAcademicSubject) {
        groupAcademicSubjectService.addGroupAcademicSubject(groupAcademicSubject);

        log.info("List of disciplines added succesfully");
    }

    @RequestMapping(value = "/listofdisciplines/{id}", method = RequestMethod.DELETE)
    public void removeDisciplinesOfList(@PathVariable("id") int id) {
        groupAcademicSubjectService.removeGroupAcademicSubject(id);

        log.info("List of disciplines remove successfully");
    }

    @RequestMapping(value = "/listofdisciplines/{id}", method = RequestMethod.PUT)
    public GroupAcademicSubject getOneListOfList(@PathVariable("id") int id) {
        log.info("Get list of dicsiplines by id: " + id);
        return groupAcademicSubjectService.getGroupAcademicSubjectById(id);
    }
}
