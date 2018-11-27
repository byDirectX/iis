package ml.bondarev.iis.restController;

import ml.bondarev.iis.model.DailyAttendance;
import ml.bondarev.iis.service.DailyAttendanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
@RequestMapping(value = "/api")
public class RestDailyAttendanceController {

    private static final Logger log = LoggerFactory.getLogger(RestDailyAttendanceController.class);

    @Autowired
    private DailyAttendanceService dailyAttendanceService;

    @RequestMapping(value = "/dailyattendance", method = RequestMethod.GET)
    public List<DailyAttendance> getListDailyAttendance() {
        return dailyAttendanceService.getListDailyAttendance();
    }

    @RequestMapping(value = "/dailyattendance", method = RequestMethod.POST)
    public void addDailyAttendance(@ModelAttribute DailyAttendance dailyAttendance) {
        dailyAttendanceService.addDailyAttendance(dailyAttendance);
    }

    @RequestMapping(value = "/dailyattendance/student", method = RequestMethod.GET)
    public List<DailyAttendance> getListDailyAttendanceForStudentName(@RequestParam("name") String name) {
        return dailyAttendanceService.getDailyAttendanceByStudentName(name);
    }

    @RequestMapping(value = "/dailyattendance", method = RequestMethod.PUT)
    public void updateDailyAttendance(@ModelAttribute DailyAttendance dailyAttendance) {
        dailyAttendanceService.updateDailyAttendance(dailyAttendance);
    }

    @RequestMapping(value = "/dailyattencance", method = RequestMethod.DELETE)
    public void removeDailyAttendance(@RequestParam("id") int id) {
        dailyAttendanceService.removeDailyAttendance(id);
    }
}
