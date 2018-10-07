package com.bondarev.shedulesubsystem.dao;

import com.bondarev.shedulesubsystem.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeDao extends JpaRepository<Time, Integer> {

}
