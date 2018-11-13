package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDao extends JpaRepository<Day, Integer> {
}
