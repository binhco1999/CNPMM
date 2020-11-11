package com.macia.HRs.service;
import com.macia.HRs.entity.User_Activity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserActivityService {
    @PersistenceContext
    private EntityManager em;

    public List<User_Activity> findAllAvailable() {
        Query query = em.createNamedQuery("useractivity_findAllAvailable", User_Activity.class);
        return query.getResultList();
    }
}