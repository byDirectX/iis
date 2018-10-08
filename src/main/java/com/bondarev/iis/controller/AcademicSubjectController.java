package com.bondarev.iis.controller;

import com.bondarev.iis.model.AcademicSubject;
import com.bondarev.iis.service.AcademicSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcademicSubjectController {

    private static final Logger log = LoggerFactory.getLogger(AcademicSubjectController.class);

    @Autowired
    private AcademicSubjectService academicSubjectService;


    @RequestMapping(value = "/academicsubject", method = RequestMethod.GET)
    public ModelAndView mainAcademicSubject(ModelAndView mav) {
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());
        mav.addObject("academicSubject", new AcademicSubject());

        log.info("Academic subjects issued sucessfully");

        mav.setViewName("academicsubject");
        return mav;
    }

    @RequestMapping(value = "/academicsubject", method = RequestMethod.POST)
    public String addAcademicSubject(@ModelAttribute AcademicSubject academicSubject) {
        if (academicSubject.getId() == 0) {
            academicSubjectService.addAcademicSubject(academicSubject);
            log.info("Academic subject added sucessfully");
        } else {
            academicSubjectService.updateAcademicSubject(academicSubject);
            log.info("Academic subject update sucessfully");
        }

        return "redirect:/academicsubject";
    }

    @RequestMapping(value = "/academicsubject/remove", method = RequestMethod.GET)
    public String removeAcademicSubject(@RequestParam("id") int id) {
        academicSubjectService.removeAcademicSubject(id);

        log.info("Academic subject remove sucessfully");

        return "redirect:/academicsubject";
    }

    @RequestMapping(value = "/academicsubject/edit", method = RequestMethod.GET)
    public ModelAndView editAcademicSubject(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("academicSubject", academicSubjectService.getAcademicSubjectById(id));
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());

        log.info("Academic subject for edit issued succesfully");

        mav.setViewName("academicsubject");
        return mav;
    }
}
