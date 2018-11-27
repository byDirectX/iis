package ml.bondarev.iis.controller;


import ml.bondarev.iis.model.Time;
import ml.bondarev.iis.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TimeController {

    @Autowired
    private TimeService timeService;


    @GetMapping(value = "/time")
    public ModelAndView getListTime(ModelAndView mav) {
        mav.addObject("timeList", timeService.getTimeList());
        mav.addObject("time", new Time());

        mav.setViewName("time");
        return mav;
    }

    @PostMapping(value = "/time")
    public String addUpdateTime(@ModelAttribute Time time) {
        if (time.getId() == 0) {
            timeService.addTime(time);
        } else {
            timeService.updateTime(time);
        }

        return "redirect:/time";
    }

    @GetMapping(value = "/time/edit")
    public ModelAndView getTimeById(@RequestParam int id, ModelAndView mav) {
        mav.addObject("timeList", timeService.getTimeList());
        mav.addObject("time", timeService.getTimeById(id));

        mav.setViewName("time");
        return mav;
    }

    @GetMapping(value = "/time/remove")
    public String removeTime(@RequestParam int id) {
        timeService.removeTime(id);

        return "redirect:/time";
    }
}
