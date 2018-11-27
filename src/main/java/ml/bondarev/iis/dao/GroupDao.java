package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group, Integer> {

}
