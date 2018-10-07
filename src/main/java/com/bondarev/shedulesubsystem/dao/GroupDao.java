package com.bondarev.shedulesubsystem.dao;

import com.bondarev.shedulesubsystem.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends JpaRepository<Group, Integer> {

}
