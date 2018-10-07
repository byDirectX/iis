package com.bondarev.shedulesubsystem.controller;

import com.bondarev.shedulesubsystem.model.Department;
import com.bondarev.shedulesubsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ModelAndView mainDepartment(ModelAndView mav) {
        mav.addObject("listDepartment", departmentService.getListDepartment());
        mav.addObject("department", new Department());

        mav.setViewName("department");
        return mav;
    }

    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute Department department) {
        if (department.getId() == 0) {
            departmentService.addDepartment(department);
        } else {
            departmentService.updateDepartment(department);
        }

        return "redirect:/department";
    }

    @RequestMapping(value = "/department/remove", method = RequestMethod.GET)
    public String removeDepartment(@RequestParam("id") int id) {
        departmentService.removeDepartment(id);

        return "redirect:/department";
    }

    @RequestMapping(value = "/department/edit", method = RequestMethod.GET)
    public ModelAndView editDepartment(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("department", departmentService.getDepartmentById(id));
        mav.addObject("listDepartment", departmentService.getListDepartment());

        mav.setViewName("department");
        return mav;
    }
}
