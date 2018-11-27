package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayDao extends JpaRepository<Day, Integer> {

}
