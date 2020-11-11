package com.macia.HRs.repository;
import com.macia.HRs.entity.Daily_Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyScheduleRepository extends JpaRepository<Daily_Schedule, Integer> {
}


