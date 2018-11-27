package ml.bondarev.iis.restController;

import ml.bondarev.iis.model.Teacher;
import ml.bondarev.iis.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping(value = "/api")
public class RestTeacherController {

    private static final Logger log = LoggerFactory.getLogger(RestTeacherController.class);

    @Autowired
    private TeacherService teacherService;


    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public List<Teacher> mainTeacher() {
        log.info("Get teacher list");
        return teacherService.getListTeacher();
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public void addTeacher(@ModelAttribute Teacher teacher) {
        if (teacher.getId() == 0) {
            teacherService.addTeacher(teacher);
            log.info("Teacher added successfully");
        } else {
            teacherService.updateTeacher(teacher);
            log.info("Teacher update successfully");
        }
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.DELETE)
    public void removeTeacher(@PathVariable("id") int id) {
        teacherService.removeTeacher(id);

        log.info("Teacher remove successfully");
    }

    @RequestMapping(value = "/teacher/{id}", method = RequestMethod.PUT)
    public Teacher getOneTeacher(@PathVariable("id") int id) {
        log.info("Get one teacher by id: " + id);
        return teacherService.getTeacherById(id);
    }
}
