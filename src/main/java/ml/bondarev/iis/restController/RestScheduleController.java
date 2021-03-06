package ml.bondarev.iis.restController;

import ml.bondarev.iis.model.Schedule;
import ml.bondarev.iis.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping(value = "/api")
public class RestScheduleController {

    private static final Logger log = LoggerFactory.getLogger(RestScheduleController.class);

    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public List<Schedule> mainSchedule() {
        log.info("Get list schedule");
        return scheduleService.getListSchedule();
    }

    @RequestMapping(value = "/schedule/group", method = RequestMethod.POST)
    public List<Schedule> selectSchedule(@RequestParam("selectGroup") String id) {
        int groupId = Integer.parseInt(id);

        return scheduleService.getListScheduleByGroupId(groupId);
    }

    @RequestMapping(value = "/schedule", method = RequestMethod.POST)
    public void addSchedule(@ModelAttribute("schedule") Schedule schedule) {
        if (schedule.getId() == 0) {
            scheduleService.addSchedule(schedule);
            log.info("Schedule added successfully");
        } else {
            scheduleService.updateSchedule(schedule);
            log.info("Schedule update successfully");
        }
    }

    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.DELETE)
    public void removeGroup(@PathVariable("id") int id) {
        scheduleService.removeSchedule(id);

        log.info("Schedule removed successfully");
    }

    @RequestMapping(value = "/schedule/{id}", method = RequestMethod.PUT)
    public Schedule getOneSchedule(@PathVariable("id") int id) {
        log.info("Get one schedule by id: " + id);
        return scheduleService.getScheduleById(id);
    }
}
