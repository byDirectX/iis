package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.Day;
import ml.bondarev.iis.model.Time;
import ml.bondarev.iis.service.DayService;
import ml.bondarev.iis.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class DayController {

    @Autowired
    private DayService dayService;

    @Autowired
    private TimeService timeService;


    @GetMapping(value = "/day/generate")
    public String generateDay(@RequestParam("date") Date date) {
        List<Time> timeList = timeService.getTimeList();
        Day day = null;

        for (int i = 0; i < timeList.size(); i++) {
            String dayName = String.format("%tA", date);
            dayName = dayName.substring(0, 1).toUpperCase() + dayName.substring(1);
            day = new Day(timeList.get(i).getId(), date, dayName);

            dayService.addDay(day);
        }

        return "redirect:dailyattendance";
    }

    @GetMapping(value = "/day")
    public ModelAndView getListDay(ModelAndView mav) {
        mav.addObject("dayList", dayService.getListDay());

        mav.setViewName("day");
        return mav;
    }
}
