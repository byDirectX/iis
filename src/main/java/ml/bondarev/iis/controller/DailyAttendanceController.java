package ml.bondarev.iis.controller;

import ml.bondarev.iis.model.DailyAttendance;
import ml.bondarev.iis.model.User;
import ml.bondarev.iis.service.DailyAttendanceService;
import ml.bondarev.iis.service.DayService;
import ml.bondarev.iis.service.TimeService;
import ml.bondarev.iis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class DailyAttendanceController {

    @Autowired
    private DailyAttendanceService dailyAttendanceService;

    @Autowired
    private DayService dayService;

    @Autowired
    private TimeService timeService;


    @GetMapping(value = "/dailyattendance")
    public ModelAndView getDailyAttendanceById(ModelAndView mav) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        mav.addObject("dailyAttendanceList", dailyAttendanceService.getDailyAttendanceByStudentName(
                auth.getName()));
        mav.addObject("dayList", dayService.getListDay());
        mav.addObject("timeList", timeService.getTimeList());

        mav.setViewName("dailyattendance");
        return mav;
    }

    @PostMapping(value = "/dailyattendance")
    public String addDailyAttendance(@RequestParam("dayId") int dayId,
                                     @RequestParam("flag") int flag) {
        dailyAttendanceService.addDailyAttendance(new DailyAttendance(
                (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                dayId, flag
        ));

        return "redirect:/dailyattendance";
    }
}
