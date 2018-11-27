package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.AcademicSubject;
import ml.bondarev.iis.service.AcademicSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcademicSubjectController {

    @Autowired
    private AcademicSubjectService academicSubjectService;


    @GetMapping(value = "/academicsubject")
    public ModelAndView getListAcademicSubject(ModelAndView mav) {
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());
        mav.addObject("academicSubject", new AcademicSubject());

        mav.setViewName("academicsubject");
        return mav;
    }

    @PostMapping(value = "/academicsubject")
    public String addUpdateAcademicSubject(@ModelAttribute AcademicSubject academicSubject) {
        if (academicSubject.getId() == 0) {
            academicSubjectService.addAcademicSubject(academicSubject);
        } else {
            academicSubjectService.updateAcademicSubject(academicSubject);
        }

        return "redirect:/academicsubject";
    }

    @GetMapping(value = "/academicsubject/edit")
    public ModelAndView getAcademicSubjectById(@RequestParam int id, ModelAndView mav) {
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());
        mav.addObject("academicSubject", academicSubjectService.getAcademicSubjectById(id));

        mav.setViewName("academicsubject");
        return mav;
    }

    @GetMapping(value = "/academicsubject/remove")
    public String removeAcademicSubject(@RequestParam int id) {
        academicSubjectService.removeAcademicSubject(id);

        return "redirect:/academicsubject";
    }
}
