package com.macia.HRs.service;

import com.macia.HRs.entity.Position;
import com.macia.HRs.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class PositionService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PositionRepository posRepo;

    public List<Position> findAllAvailable() {
        Query query = em.createNamedQuery("position_findAllAvailable", Position.class);
        return query.getResultList();
    }
}