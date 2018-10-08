package com.bondarev.iis.controller;

import com.bondarev.iis.model.Time;
import com.bondarev.iis.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimeController {

    @Autowired
    private TimeService timeService;


    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public ModelAndView mainTime(ModelAndView mav) {
        mav.addObject("listTime", timeService.getTimeList());
        mav.addObject("time", new Time());

        mav.setViewName("time");
        return mav;
    }

    @RequestMapping(value = "/time", method = RequestMethod.POST)
    public String addTime(@ModelAttribute Time time) {
        if (time.getId() == 0) {
            timeService.addTime(time);
        } else {
            timeService.updateTime(time);
        }

        return "redirect:/time";
    }

    @RequestMapping(value = "/time/remove", method = RequestMethod.GET)
    public String removeTime(@RequestParam("id") int id) {
        timeService.removeTime(id);

        return "redirect:/time";
    }

    @RequestMapping(value = "/time/edit", method = RequestMethod.GET)
    public ModelAndView editTime(@RequestParam("id") int id, ModelAndView mav) {
        mav.addObject("time", timeService.getTimeById(id));
        mav.addObject("listTime", timeService.getTimeList());

        mav.setViewName("time");
        return mav;
    }
}
