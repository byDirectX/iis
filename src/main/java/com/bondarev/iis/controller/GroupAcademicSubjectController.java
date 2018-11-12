package com.bondarev.iis.controller;

import com.bondarev.iis.model.GroupAcademicSubject;
import com.bondarev.iis.service.AcademicSubjectService;
import com.bondarev.iis.service.GroupAcademicSubjectService;
import com.bondarev.iis.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupAcademicSubjectController {

    private static final Logger log = LoggerFactory.getLogger(GroupAcademicSubjectController.class);

    @Autowired
    private GroupAcademicSubjectService groupAcademicSubjectService;

    @Autowired
    private AcademicSubjectService academicSubjectService;

    @Autowired
    private GroupService groupService;


    @RequestMapping(value = "/listofdisciplines", method = RequestMethod.GET)
    public ModelAndView mainListOfDisciplines(ModelAndView mav) {
        mav.addObject("listGroupAcademicSubject", groupAcademicSubjectService.getListGroupAcademicSubject());
        mav.addObject("listAcademicSubject", academicSubjectService.getListAcademicSubject());
        mav.addObject("listGroup", groupService.getListGroup());

        log.info("List of disciplines issued sucessfully");

        mav.setViewName("listofdisciplines");
        return mav;
    }

    @RequestMapping(value = "/listofdisciplines", method = RequestMethod.POST)
    public String addDisciplinesOnList(@ModelAttribute GroupAcademicSubject groupAcademicSubject) {
        groupAcademicSubjectService.addGroupAcademicSubject(groupAcademicSubject);

        return "redirect:/listofdisciplines";
    }

    @RequestMapping(value = "/listofdisciplines/remove", method = RequestMethod.GET)
    public String removeDisciplinesOnList(@RequestParam("id") int id) {
        groupAcademicSubjectService.removeGroupAcademicSubject(id);

        return "redirect:/listofdisciplines";
    }

    @RequestMapping(value = "/listofdisciplines/edit", method = RequestMethod.GET)
    public ModelAndView editListDisciplines(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("discipline", groupAcademicSubjectService.getGroupAcademicSubjectById(id));
        mav.addObject("listGroupAcademicSubject", groupAcademicSubjectService.getListGroupAcademicSubject());

        mav.setViewName("listofdisciplines");
        return mav;
    }
}
