package com.bondarev.iis.controller;

import com.bondarev.iis.model.Teacher;
import com.bondarev.iis.service.DepartmentService;
import com.bondarev.iis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private DepartmentService departmentService;

     @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView mainTeacher(ModelAndView mav) {
        mav.addObject("listTeacher", teacherService.getListTeacher());
        mav.addObject("listDepartments", departmentService.getListDepartment());
        mav.addObject("teacher", new Teacher());

        mav.setViewName("teacher");
        return mav;
    }

    @RequestMapping(value = "/teacher", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute Teacher teacher) {
        if (teacher.getId() == 0) {
            teacherService.addTeacher(teacher);
        } else {
            teacherService.updateTeacher(teacher);
        }

        return "redirect:/teacher";
    }

    @RequestMapping(value = "/teacher/remove", method = RequestMethod.GET)
    public String removeTeacher(@RequestParam("id") int id) {
        teacherService.removeTeacher(id);

        return "redirect:/teacher";
    }

    @RequestMapping(value = "/teacher/edit", method = RequestMethod.GET)
    public ModelAndView editTeacher(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("teacher", teacherService.getTeacherById(id));
        mav.addObject("listTeacher", teacherService.getListTeacher());

        mav.setViewName("teacher");
        return mav;
    }
}
