package ml.bondarev.iis.service;

import ml.bondarev.iis.dao.DailyAttendanceDao;
import ml.bondarev.iis.model.DailyAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyAttendanceServiceImpl implements DailyAttendanceService {

    @Autowired
    private DailyAttendanceDao dailyAttendanceDao;


    @Override
    public List<DailyAttendance> getListDailyAttendance() {
        return dailyAttendanceDao.findAll();
    }

    @Override
    public void addDailyAttendance(DailyAttendance dailyAttendance) {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        DailyAttendance da = dailyAttendanceDao.getDailyAttendanceByDayIdAndUserName(dailyAttendance.getDayId(), name);

        if (da == null) {
            dailyAttendanceDao.save(dailyAttendance);
        } else {
            da.setFlag(dailyAttendance.getFlag());
            dailyAttendanceDao.saveAndFlush(da);
        }
    }

    @Override
    public void updateDailyAttendance(DailyAttendance dailyAttendance) {
        dailyAttendanceDao.saveAndFlush(dailyAttendance);
    }

    @Override
    public List<DailyAttendance> getDailyAttendanceByStudentName(String name) {
        return dailyAttendanceDao.getDailyAttendanceByStudentName(name);
    }

    @Override
    public void removeDailyAttendance(int id) {
        dailyAttendanceDao.deleteById(id);
    }
}
