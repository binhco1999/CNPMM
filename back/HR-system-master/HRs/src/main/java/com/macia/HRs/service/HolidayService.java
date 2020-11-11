package com.macia.HRs.service;

import com.macia.HRs.entity.Holiday;
import com.macia.HRs.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class HolidayService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private HolidayRepository holRepo;

    public List<Holiday> findAllAvailable() {
        Query query = em.createNamedQuery("holiday_findAllAvailable", Holiday.class);
        return query.getResultList();
    }
}