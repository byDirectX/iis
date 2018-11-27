package ml.bondarev.iis.dao;

import ml.bondarev.iis.model.GroupAcademicSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupAcademicSubjectDao extends JpaRepository<GroupAcademicSubject, Integer> {
}
