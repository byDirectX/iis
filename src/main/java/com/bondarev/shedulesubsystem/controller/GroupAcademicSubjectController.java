package com.bondarev.shedulesubsystem.controller;

import com.bondarev.shedulesubsystem.model.GroupAcademicSubject;
import com.bondarev.shedulesubsystem.service.AcademicSubjectService;
import com.bondarev.shedulesubsystem.service.GroupAcademicSubjectService;
import com.bondarev.shedulesubsystem.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupAcademicSubjectController {

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

        mav.setViewName("listofdisciplines");
        return mav;
    }

    //@RequestMapping(value = "/listofdisciplines", method = RequestMethod.POST)
    public String addDisciplinesOnList(@ModelAttribute GroupAcademicSubject groupAcademicSubject) {
        groupAcademicSubjectService.addGroupAcademicSubject(groupAcademicSubject);

        return "redirect:/listofdisciplines";
    }

    public String removeDisciplinesOnList(@RequestParam("id") int id) {
        groupAcademicSubjectService.removeGroupAcademicSubject(id);

        return "redirect:/listofdisciplines";
    }

    public ModelAndView editListDisciplines(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("discipline", groupAcademicSubjectService.getGroupAcademicSubjectById(id));
        mav.addObject("listGroupAcademicSubject", groupAcademicSubjectService.getListGroupAcademicSubject());

        mav.setViewName("listofdisciplines");
        return mav;
    }
}
