package com.macia.HRs.repository;
import com.macia.HRs.entity.Employee_Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeShiftRepository extends JpaRepository<Employee_Shift, Integer> {
}
