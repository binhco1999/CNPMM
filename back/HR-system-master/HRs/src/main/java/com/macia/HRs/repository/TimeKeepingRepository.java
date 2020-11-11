package com.macia.HRs.repository;

import com.macia.HRs.entity.TimeKeeping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeKeepingRepository extends JpaRepository<TimeKeeping, Integer> {
}