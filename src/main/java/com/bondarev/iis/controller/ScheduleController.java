package com.bondarev.iis.controller;

import com.bondarev.iis.model.Schedule;
import com.bondarev.iis.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private DayService dayService;

    @Autowired
    private TimeService timeService;

    @Autowired
    private AcademicSubjectService academicSubjectService;

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public ModelAndView mainSchedule(ModelAndView mav) {
        mav.addObject("listGroup", groupService.getListGroup());
        mav.addObject("schedule", new Schedule());

        // =========== //

        mav.addObject("listDay", dayService.getListDay());
        mav.addObject("timeList", timeService.getTimeList());
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());
        mav.addObject("teacherList", teacherService.getListTeacher());

        // =========== //

        mav.setViewName("schedule");
        return mav;
    }

    @RequestMapping(value = "/schedule/group", method = RequestMethod.POST)
    public ModelAndView selectSchedule(@RequestParam("selectGroup") String id,
                                    ModelAndView mav) {
        int groupId = Integer.parseInt(id);
        mav.addObject("schedule", new Schedule());
        mav.addObject("groupId", groupService.getGroupById(groupId));
        mav.addObject("listSchedule", scheduleService.getListScheduleByGroupId(groupId));
        mav.addObject("listGroup", groupService.getListGroup());
        mav.addObject("listDay", dayService.getListDay());
        mav.addObject("timeList", timeService.getTimeList());
        mav.addObject("academicSubjectList", academicSubjectService.getListAcademicSubject());
        mav.addObject("teacherList", teacherService.getListTeacher());

        mav.setViewName("schedule");
        return mav;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public ModelAndView addSchedule(@ModelAttribute("schedule") Schedule schedule, ModelAndView mav) {
        if (schedule.getId() == 0) {
            scheduleService.addSchedule(schedule);
        } else {
            scheduleService.updateSchedule(schedule);
        }

        mav.addObject("listGroup", groupService.getListGroup());

        mav.setViewName("schedule");
        return mav;
    }

    @RequestMapping(value = "/schedule/remove", method = RequestMethod.GET)
    public String removeGroup(@RequestParam("id") int id) {
        scheduleService.removeSchedule(id);

        return "redirect:/schedule";
    }

    @RequestMapping(value = "/schedule/edit", method = RequestMethod.GET)
    public ModelAndView editGroup(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("schedule", scheduleService.getScheduleById(id));
        mav.addObject("listSchedule", scheduleService.getListSchedule());

        mav.setViewName("schedule");
        return mav;
    }
}
