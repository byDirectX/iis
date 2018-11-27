package ml.bondarev.iis.service;

import ml.bondarev.iis.model.DailyAttendance;

import java.util.List;

public interface DailyAttendanceService {

    public List<DailyAttendance> getListDailyAttendance();

    public void addDailyAttendance(DailyAttendance dailyAttendance);

    public void updateDailyAttendance(DailyAttendance dailyAttendance);

    public List<DailyAttendance> getDailyAttendanceByStudentName(String name);

    public void removeDailyAttendance(int id);
}
