package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
