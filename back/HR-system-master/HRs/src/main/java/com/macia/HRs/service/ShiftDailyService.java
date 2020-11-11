package com.macia.HRs.service;

import com.macia.HRs.entity.Shift_Daily;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class ShiftDailyService {
    @PersistenceContext
    private EntityManager em;

    public List<Shift_Daily> findAllAvailable() {
        Query query = em.createNamedQuery("shiftdaily_findAllAvailable", Shift_Daily.class);
        return query.getResultList();
    }
}