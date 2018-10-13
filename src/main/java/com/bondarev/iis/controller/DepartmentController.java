package com.bondarev.iis.controller;

import com.bondarev.iis.model.Department;
import com.bondarev.iis.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {

    private static final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;


    @RequestMapping(value = "/department", method = RequestMethod.GET)
    public ModelAndView mainDepartment(ModelAndView mav) {
        mav.addObject("listDepartment", departmentService.getListDepartment());
        mav.addObject("department", new Department());

        log.info("Department issued sucessfully");

        mav.setViewName("department");
        return mav;
    }

    @Secured(value = "USER")
    @RequestMapping(value = "/department", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute Department department) {
        if (department.getId() == 0) {
            departmentService.addDepartment(department);
            log.info("Department added sucessfully");
        } else {
            departmentService.updateDepartment(department);
            log.info("Department update sucessfully");
        }

        return "redirect:/department";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/department/remove", method = RequestMethod.GET)
    public String removeDepartment(@RequestParam("id") int id) {
        departmentService.removeDepartment(id);

        log.info("Department remove sucessfully");

        return "redirect:/department";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/department/edit", method = RequestMethod.GET)
    public ModelAndView editDepartment(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("department", departmentService.getDepartmentById(id));
        mav.addObject("listDepartment", departmentService.getListDepartment());

        log.info("Department for edit issued sucessfully");

        mav.setViewName("department");
        return mav;
    }
}
