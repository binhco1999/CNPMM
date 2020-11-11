package com.macia.HRs.api;

import com.macia.HRs.entity.Employee;
import com.macia.HRs.entity.Employee_Shift;
import com.macia.HRs.repository.EmployeeShiftRepository;
import com.macia.HRs.service.EmployeeShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/empshifts")
public class EmployeeShiftResource {

    @Autowired
    private EmployeeShiftRepository emsRepo;

    @Autowired
    private EmployeeShiftService emsService;


    @GetMapping()
    @CrossOrigin("*")
    public List<Employee_Shift> getAllEmployee_Shift(){
        return emsService.findAllAvailable();
    }

    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteEmployee_Shift(@PathVariable(value = "id") Integer Employee_ShiftId,@PathVariable(value = "uid") Integer uid) throws Exception {
        Employee_Shift emps =
                emsRepo
                        .findById(Employee_ShiftId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee_Shift not found on :: " + Employee_ShiftId));
        emps.setIsdeleted(Boolean.TRUE);
        emps.setModifyBy(uid);
        emsRepo.save(emps);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Employee_Shift> getEmployee_ShiftById(@PathVariable(value = "id") Integer Employee_ShiftId)
            throws ResourceNotFoundException {
        Employee_Shift Employee_Shift =
                emsRepo
                        .findById(Employee_ShiftId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee_Shift not found on :: " + Employee_ShiftId));
        return ResponseEntity.ok().body(Employee_Shift);
    }

    @PostMapping()
    @CrossOrigin("*")
    public Employee_Shift createEmployee_Shift(@RequestBody Employee_Shift Employee_Shift) {
        return emsRepo.save(Employee_Shift);
    }
}