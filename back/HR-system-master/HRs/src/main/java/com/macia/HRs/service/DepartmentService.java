package com.macia.HRs.service;

import com.macia.HRs.entity.Department;
import com.macia.HRs.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class DepartmentService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DepartmentRepository depRepo;

    public List<Department> findAllDepartmentAvailable() {
        Query query = em.createNamedQuery("department_findAllAvailable", Department.class);
        return query.getResultList();
    }
}