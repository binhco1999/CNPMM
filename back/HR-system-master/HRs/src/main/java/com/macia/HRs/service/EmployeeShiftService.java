package com.macia.HRs.service;

import com.macia.HRs.entity.Employee_Shift;
import com.macia.HRs.repository.DailyScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class EmployeeShiftService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DailyScheduleRepository dlsRepo;

    public List<Employee_Shift> findAllAvailable() {
        Query query = em.createNamedQuery("employeeshift_findAllAvailable", Employee_Shift.class);
        return query.getResultList();
    }
}