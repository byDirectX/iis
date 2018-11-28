package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.DailyAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DailyAttendanceDao extends JpaRepository<DailyAttendance, Integer> {

    @Query("select da from DailyAttendance da where da.userName=:name")
    public List<DailyAttendance> getDailyAttendanceByStudentName(@Param("name") String name);

    @Query("select da from DailyAttendance da where da.dayId=:dayId and da.userName=:userName")
    public DailyAttendance getDailyAttendanceByDayIdAndUserName(@Param("dayId") int id, @Param("userName") String name);

}
