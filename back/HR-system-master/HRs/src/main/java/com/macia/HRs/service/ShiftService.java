package com.macia.HRs.service;

import com.macia.HRs.entity.Shift;
import com.macia.HRs.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class ShiftService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PositionRepository posRepo;

    public List<Shift> findAllAvailable() {
        Query query = em.createNamedQuery("shift_findAllAvailable", Shift.class);
        return query.getResultList();
    }
}