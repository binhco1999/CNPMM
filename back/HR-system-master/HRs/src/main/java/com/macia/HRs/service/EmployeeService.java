package com.macia.HRs.service;

import com.macia.HRs.entity.Employee;
import com.macia.HRs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class EmployeeService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private EmployeeRepository empRepo;

    //Using NamedStoredProcedure
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmpViaProcByFirstName(String firstname) {
        StoredProcedureQuery storedProcedureQuery = this.em.createNamedStoredProcedureQuery("named_getEmployeeLikeName");
        storedProcedureQuery.setParameter("firstname", firstname);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getResultList();
    }


    //Using Maned Query
    public List<Employee> findEmployeeByFirstName(String fistname){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByFirstName", Employee.class);
        query.setParameter("firstname", fistname.toLowerCase());
        return query.getResultList();
    }
    public List<Employee> findEmployeeByCode(String code){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByCode", Employee.class);
        query.setParameter("code", code.toLowerCase());
        return query.getResultList();
    }
    public List<Employee> getEmloyeeByDepartmentAndPosition(int deptid,int posid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByDepAndPos", Employee.class);
		query.setParameter("deptid",deptid);
		query.setParameter("posid",posid);
		return query.getResultList();	
	}
    
    public List<Employee> getEmloyeeByCodeAndPosition(String code,int posid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByCodeAndPos", Employee.class);
        query.setParameter("code",code);
		query.setParameter("posid",posid);
		return query.getResultList();
	}
    public List<Employee> getEmloyeeByCodeAndDepartment(String code,int deptid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByCodeAndDep", Employee.class);
		query.setParameter("code",code);
		query.setParameter("deptid",deptid);
		return query.getResultList();
	}
    public List<Employee> getEmloyeeByCodeAndDepartmentAndPosition(String code,int deptid,int posid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByCodeAndDepAndPos", Employee.class);
  		query.setParameter("code",code);
  		query.setParameter("deptid",deptid);
  		query.setParameter("posid",posid);
  		return query.getResultList();
  	}
    public List<Employee> getEmloyeeByFnameAndPosition(String fname,int posid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByFnameAndPos", Employee.class);
        query.setParameter("fname",fname);
        query.setParameter("posid",posid);
        return query.getResultList();
    }
    public List<Employee> getEmloyeeByFnameAndDepartment(String fname,int deptid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByFnameAndDep", Employee.class);
        query.setParameter("fname",fname);
        query.setParameter("deptid",deptid);
        return query.getResultList();
    }
    public List<Employee> getEmloyeeByFnameAndDepartmentAndPosition(String fname,int deptid,int posid){
        Query query =  em.createNamedQuery("employee_findAllEmployeeByFnameAndDepAndPos", Employee.class);
        query.setParameter("fname",fname);
        query.setParameter("deptid",deptid);
        query.setParameter("posid",posid);
        return query.getResultList();
    }
}
