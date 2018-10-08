package com.bondarev.iis.controller;

import com.bondarev.iis.model.AcademicSubject;
import com.bondarev.iis.service.AcademicSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcademicSubjectController {

    @Autowired
    private AcademicSubjectService academicSubjectService;


    @RequestMapping(value = "/academicsubject", method = RequestMethod.GET)
    public ModelAndView mainAcademicSubject(ModelAndView mav) {
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());
        mav.addObject("academicSubject", new AcademicSubject());

        mav.setViewName("academicsubject");
        return mav;
    }

    @RequestMapping(value = "/academicsubject", method = RequestMethod.POST)
    public String addAcademicSubject(@ModelAttribute AcademicSubject academicSubject) {
        if (academicSubject.getId() == 0) {
            academicSubjectService.addAcademicSubject(academicSubject);
        } else {
            academicSubjectService.updateAcademicSubject(academicSubject);
        }
        return "redirect:/academicsubject";
    }

    @RequestMapping(value = "/academicsubject/remove", method = RequestMethod.GET)
    public String removeAcademicSubject(@RequestParam("id") int id) {
        academicSubjectService.removeAcademicSubject(id);

        return "redirect:/academicsubject";
    }

    @RequestMapping(value = "/academicsubject/edit", method = RequestMethod.GET)
    public ModelAndView editAcademicSubject(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("academicSubject", academicSubjectService.getAcademicSubjectById(id));
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());

        mav.setViewName("academicsubject");
        return mav;
    }
}
