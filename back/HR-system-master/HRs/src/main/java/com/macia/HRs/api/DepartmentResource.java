package com.macia.HRs.api;

import com.macia.HRs.entity.Department;
import com.macia.HRs.repository.DepartmentRepository;
import com.macia.HRs.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/departments")
public class DepartmentResource {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentService depService;


    @CrossOrigin(origins="*")
    @GetMapping()
    public List<Department> getAllDepartment(){
        return depService.findAllDepartmentAvailable();
    }

    @GetMapping("/count")
    @CrossOrigin("*")
    public Long count() {

        return departmentRepository.count();
    }
    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Integer departmentId,@PathVariable(value = "uid") Integer uid) throws Exception {
        Department department =
                departmentRepository
                        .findById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Department not found on :: " + departmentId));
        department.setIsdeleted(Boolean.TRUE);
        department.setModifyBy(uid);
        departmentRepository.save(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Integer departmentId)
            throws ResourceNotFoundException {
        Department department =
                departmentRepository
                        .findById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Department not found on :: " + departmentId));
        return ResponseEntity.ok().body(department);
    }

    @PostMapping()
    @CrossOrigin("*")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    public ResponseEntity<Department> updateDepartment(
            @PathVariable(value = "id") Integer departmentId,
            @PathVariable(value = "uid") Integer uid,
            @RequestBody Department departmentDetails)
            throws ResourceNotFoundException {
        Department department =
                departmentRepository
                        .findById(departmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Department not found on :: " + departmentId));
        department.setDepartmentName(departmentDetails.getDepartmentName());
        department.setStartDate(departmentDetails.getStartDate());
        department.setModifyBy(uid);
        final Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

}