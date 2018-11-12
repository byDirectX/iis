package com.bondarev.iis.controller;

import com.bondarev.iis.model.Schedule;
import com.bondarev.iis.service.*;
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
public class ScheduleController {

    private static final Logger log = LoggerFactory.getLogger(ScheduleController.class);

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

        log.info("Main page schedule return");

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

        log.info("Schedule issued sucessfully for group: " + groupService.getGroupById(groupId).getName());

        mav.setViewName("schedule");
        return mav;
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public ModelAndView addSchedule(@ModelAttribute("schedule") Schedule schedule, ModelAndView mav) {
        if (schedule.getId() == 0) {
            scheduleService.addSchedule(schedule);
            log.info("Schedule added sucessfully");
        } else {
            scheduleService.updateSchedule(schedule);
            log.info("Schedule update sucessfully");
        }

        mav.addObject("listGroup", groupService.getListGroup());

        mav.setViewName("schedule");
        return mav;
    }

    @RequestMapping(value = "/schedule/remove", method = RequestMethod.GET)
    public String removeGroup(@RequestParam("id") int id) {
        scheduleService.removeSchedule(id);

        log.info("Schedule removed sucessfully");

        return "redirect:/schedule";
    }

    @RequestMapping(value = "/schedule/edit", method = RequestMethod.GET)
    public ModelAndView editGroup(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("schedule", scheduleService.getScheduleById(id));
        mav.addObject("listSchedule", scheduleService.getListSchedule());

        log.info("Schedule for edit issued sucessfully");

        mav.setViewName("schedule");
        return mav;
    }
}
