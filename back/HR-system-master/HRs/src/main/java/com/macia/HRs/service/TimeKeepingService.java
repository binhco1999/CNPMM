package com.macia.HRs.service;

import com.macia.HRs.DTO.TimeKeepingDTO;
import com.macia.HRs.entity.TimeKeeping;
import com.macia.HRs.repository.EmployeeRepository;
import com.macia.HRs.repository.TimeKeepingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeKeepingService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private TimeKeepingRepository tkpRepo;

    @Autowired
    private EmployeeRepository empRepo;

    //Using NamedStoredProcedure
    @SuppressWarnings("unchecked")
    public Integer syncTKPDataViaProcByDate(String date) {
        StoredProcedureQuery storedProcedureQuery = this.em.createNamedStoredProcedureQuery("named_syncDataOnDate");
        storedProcedureQuery.setParameter("date", date);
        storedProcedureQuery.execute();
        return storedProcedureQuery.getUpdateCount();
    }


    @SuppressWarnings("unchecked")
    public List<TimeKeepingDTO> getTimeKeepingByDeptIDAndDate(String date, Integer depid) {
        StoredProcedureQuery query = this.em
                .createNamedStoredProcedureQuery("named_getTimeKeepingByDateAndDepId");
        query.setParameter("date",date);
        query.setParameter("depid",depid);
        query.execute();
        return  query.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<TimeKeepingDTO> getTimeKeepingByDate(String date) {
        StoredProcedureQuery query = this.em
                .createNamedStoredProcedureQuery("named_getTimeKeepingByDate");
        query.setParameter("date",date);
        query.execute();
        return  query.getResultList();
    }
//    public List<Integer> listEventSuccess(){
//        //-- CODE CHẤM CÔNG THÀNH CÔNG: 43->53 ,55, 58 -> 62
//        List<Integer> listEventSuccess = new ArrayList<>();
//        for(int i = 43;i<=53;i++){
//            listEventSuccess.add(i);
//        }
//        listEventSuccess.add(55);
//        listEventSuccess.add(58);
//        for(int i = 58;i<=62;i++){
//            listEventSuccess.add(i);
//        }
//        return listEventSuccess;
//    }
}
