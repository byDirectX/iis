package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeDao extends JpaRepository<Time, Integer> {

}
