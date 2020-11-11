package com.macia.HRs.repository;
import com.macia.HRs.entity.Shift_Daily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftDailyRepository extends JpaRepository<Shift_Daily, Integer> {
}

