package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.Time;
import ml.bondarev.iis.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TimeController {

    private static final Logger log = LoggerFactory.getLogger(TimeController.class);

    @Autowired
    private TimeService timeService;


    @RequestMapping(value = "/time", method = RequestMethod.GET)
    public List<Time> mainTime(ModelAndView mav) {
        return timeService.getTimeList();
    }

    @RequestMapping(value = "/time", method = RequestMethod.POST)
    public void addTime(@ModelAttribute Time time) {
        if (time.getId() == 0) {
            timeService.addTime(time);
            log.info("Time added successfully");
        } else {
            timeService.updateTime(time);
            log.info("Time update successfully");
        }
    }

    @RequestMapping(value = "/time/{id}", method = RequestMethod.DELETE)
    public void removeTime(@PathVariable("id") int id) {
        timeService.removeTime(id);
    }

    @RequestMapping(value = "/time/{id}", method = RequestMethod.PUT)
    public Time getOneTime(@PathVariable("id") int id) {
        return timeService.getTimeById(id);
    }
}
