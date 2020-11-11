package com.macia.HRs.service;

import com.macia.HRs.entity.Daily_Schedule;
import com.macia.HRs.repository.DailyScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DailyScheduleService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DailyScheduleRepository dlsRepo;

    public List<Daily_Schedule> findAllAvailable() {
        Query query = em.createNamedQuery("dailyschedule_findAllAvailable", Daily_Schedule.class);
        return query.getResultList();
    }
}