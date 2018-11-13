package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleDao extends JpaRepository<Schedule, Integer> {

    @Query("select sch from Schedule sch where sch.groupId =:groupId")
    public List<Schedule> getListScheduleByGroupId(@Param("groupId") int groupId);

}
