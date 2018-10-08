package com.bondarev.iis.controller;

import com.bondarev.iis.model.Teacher;
import com.bondarev.iis.service.DepartmentService;
import com.bondarev.iis.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    private static final Logger log = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private DepartmentService departmentService;

     @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView mainTeacher(ModelAndView mav) {
        mav.addObject("listTeacher", teacherService.getListTeacher());
        mav.addObject("listDepartments", departmentService.getListDepartment());
        mav.addObject("teacher", new Teacher());

        log.info("Teacher issued sucessfully");

        mav.setViewName("teacher");
        return mav;
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute Teacher teacher) {
        if (teacher.getId() == 0) {
            teacherService.addTeacher(teacher);
            log.info("Teacher added sucessfully");
        } else {
            teacherService.updateTeacher(teacher);
            log.info("Teacher update sucessfully");
        }

        return "redirect:/teacher";
    }

    @RequestMapping(value = "/teacher/remove", method = RequestMethod.GET)
    public String removeTeacher(@RequestParam("id") int id) {
        teacherService.removeTeacher(id);

        log.info("Teacher remove sucessfully");

        return "redirect:/teacher";
    }

    @RequestMapping(value = "/teacher/edit", method = RequestMethod.GET)
    public ModelAndView editTeacher(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("teacher", teacherService.getTeacherById(id));
        mav.addObject("listTeacher", teacherService.getListTeacher());

        log.info("Teacher for edit issued sucessfully");

        mav.setViewName("teacher");
        return mav;
    }
}
