package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.GroupAcademicSubject;
import ml.bondarev.iis.service.GroupAcademicSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GroupAcademicSubjectController {

    private static final Logger log = LoggerFactory.getLogger(GroupAcademicSubjectController.class);

    @Autowired
    private GroupAcademicSubjectService groupAcademicSubjectService;


    @RequestMapping(value = "/listofdisciplines", method = RequestMethod.GET)
    public List<GroupAcademicSubject> getListOfDisciplines() {
        return groupAcademicSubjectService.getListGroupAcademicSubject();
    }

    @RequestMapping(value = "/listofdisciplines", method = RequestMethod.POST)
    public void addDisciplinesOfList(@ModelAttribute GroupAcademicSubject groupAcademicSubject) {
        groupAcademicSubjectService.addGroupAcademicSubject(groupAcademicSubject);
    }

    @RequestMapping(value = "/listofdisciplines/{id}", method = RequestMethod.DELETE)
    public void removeDisciplinesOfList(@PathVariable("id") int id) {
        groupAcademicSubjectService.removeGroupAcademicSubject(id);

        log.info("List of disciplines remove successfully");
    }

    @RequestMapping(value = "/listofdisciplines/{id}", method = RequestMethod.PUT)
    public GroupAcademicSubject getOneListOfList(@PathVariable("id") int id) {
        return groupAcademicSubjectService.getGroupAcademicSubjectById(id);
    }
}
