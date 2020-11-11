package com.macia.HRs.api;


import com.macia.HRs.entity.Department;
import com.macia.HRs.entity.Employee;
import com.macia.HRs.entity.Position;
import com.macia.HRs.repository.DepartmentRepository;
import com.macia.HRs.repository.EmployeeRepository;
import com.macia.HRs.repository.PositionRepository;
import com.macia.HRs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResource {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository deptRepo;

    @Autowired
    private PositionRepository posRepo;

//    @GetMapping()
//    @ResponseBody
//    public List<Employee> getAllEmployee(){
//        return employeeRepository.findAllWithouyNplusOne();
//    }

    @GetMapping()
    @ResponseBody
    @CrossOrigin("*")
    public List<Employee> getAllEmployeeNoneDeleted(){
        return employeeRepository.findAllWithouyNplusOneAvailable();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @CrossOrigin("*")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer EmployeeId)
            throws ResourceNotFoundException {
        Employee Employee =
                employeeRepository
                        .findById(EmployeeId)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + EmployeeId));
        return ResponseEntity.ok().body(Employee);
    }
    
    @GetMapping("/count")
    @CrossOrigin("*")
    public Long count() {
        return employeeRepository.count();
    }

    @DeleteMapping("/{id}/uid/{uid}")
    @CrossOrigin("*")
    @ResponseBody
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer empID,@PathVariable(value = "uid") Integer uid) throws Exception {
        Employee employee =
                employeeRepository
                        .findById(empID)
                        .orElseThrow(() -> new ResourceNotFoundException("Employee not found on :: " + empID));
        employee.setIsdeleted(Boolean.TRUE);
        employee.setModifyBy(uid);
        employeeRepository.save(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted Employee Name: "+employee.getFullName(), Boolean.TRUE);
        return response;
    }



    @GetMapping("/dept/{deptid}")
    @CrossOrigin("*")
    @ResponseBody
    public List<Employee> getAllEmployeeByDeptId(@PathVariable(value = "deptid") Integer deptid){
        return employeeRepository.findByDepartment(deptRepo.findById(deptid));
    }

    @GetMapping("/pos/{posid}")
    @CrossOrigin("*")
    @ResponseBody
    public List<Employee> getAllEmployeeByPosId(@PathVariable(value = "posid") Integer posid){
        return employeeRepository.findByPosition(posRepo.findById(posid));
    }
    
    @GetMapping("/dept/{deptid}/count")
    @CrossOrigin("*")
    public Integer countEmployeeInDepartment(@PathVariable(value = "deptid") Integer deptid) {
        return employeeRepository.findByDepartment(deptRepo.findById(deptid)).size();
    }

    @GetMapping("/name/{name}")
    @CrossOrigin("*")
    @ResponseBody
    public List<Employee> getEmployeeByFirstName(@PathVariable(value = "name") String name)
            throws ResourceNotFoundException {
        return employeeRepository.findByFirstName(name);
    }

    @CrossOrigin("*")
    @PostMapping("/create/dept/{deptid}")
    public Employee createEmployeeWithDeptID(@RequestBody Employee employee,@PathVariable(value = "deptid") Integer deptid) {
        Department department = deptRepo.findById(deptid).orElseThrow(null);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }
    @CrossOrigin("*")
    @PostMapping("/create/pos/{posid}")
    public Employee createEmployeeWithPostID(@RequestBody Employee employee,@PathVariable(value = "posid") Integer posid) {
        Position position = posRepo.findById(posid).orElseThrow(null);
        employee.setPosition(position);
        return employeeRepository.save(employee);
    }
  
    @PostMapping("/create/dept/{deptid}/pos/{posid}")
    @CrossOrigin("*")
    public Employee createEmployeeWithDeptAndPostID(@RequestBody Employee employee,@PathVariable(value = "deptid") Integer deptid,@PathVariable(value = "posid") Integer posid) {
        Department department = deptRepo.findById(deptid).orElseThrow(null);
        employee.setDepartment(department);
        Position position = posRepo.findById(posid).orElseThrow(null);
        employee.setPosition(position);
        return employeeRepository.save(employee);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{eid}/dept/{deptid}/pos/{posid}")
	public Employee updateEmployeeById(@RequestBody Employee employee,@PathVariable int eid,@PathVariable int deptid,@PathVariable int posid) {
    	Employee e=employeeRepository.findById(eid).orElseThrow(null);
    	Department d=deptRepo.findById(deptid).orElseThrow(null);
		Position p=posRepo.findById(posid).orElseThrow(null);
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setStartdate(employee.getStartdate());
		e.setDepartment(d);
		e.setPosition(p);
		return employeeRepository.save(e);
	}

	/*[Start]==========================---Multiple Search---==========================*/
    @GetMapping("/find/code/{code}")
    @CrossOrigin("*")
    @ResponseBody
    public List<Employee> getEmployeeByCode(@PathVariable(value = "code") String empcode)
            throws ResourceNotFoundException {
        return employeeService.findEmployeeByCode(empcode);
    }

    @CrossOrigin("*")
    @GetMapping("/find/fname/{fname}")
    @ResponseBody
    public List<Employee> findEmployeeByFirstName(@PathVariable(value = "fname") String fname)
            throws ResourceNotFoundException {
        return employeeService.findEmployeeByFirstName(fname);
    }

    @GetMapping("/find/dept/{deptid}/pos/{posid}")
    @CrossOrigin("*")
    @ResponseBody
    public List<Employee> getAllEmployeeByDeptIdAndPosId(@PathVariable(value = "deptid") Integer deptid,@PathVariable(value = "posid") Integer posid){
        return employeeService.getEmloyeeByDepartmentAndPosition(deptid, posid);
    }

    @GetMapping("/find/code/{code}/pos/{posid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByCodeAndPosId(@PathVariable(value = "code") String code,@PathVariable(value = "posid") Integer posid){
    	 return ResponseEntity.ok().body(employeeService.getEmloyeeByCodeAndPosition(code,posid));
    }

    @GetMapping("/find/code/{code}/dept/{deptid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByCodeAndDept(@PathVariable(value = "code") String code,@PathVariable(value = "deptid") Integer deptid){
    	 return ResponseEntity.ok().body(employeeService.getEmloyeeByCodeAndDepartment(code,deptid));
    }

    @GetMapping("/find/code/{code}/dept/{deptid}/pos/{posid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByCodeAndDeptAndPos(@PathVariable(value = "code") String code,@PathVariable(value = "deptid") Integer deptid,@PathVariable(value = "posid") Integer posid){
    	 return ResponseEntity.ok().body(employeeService.getEmloyeeByCodeAndDepartmentAndPosition(code, deptid, posid));
    }

    @GetMapping("/find/fname/{fname}/pos/{posid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByfnameAndPosId(@PathVariable(value = "fname") String fname,@PathVariable(value = "posid") Integer posid){
        return ResponseEntity.ok().body(employeeService.getEmloyeeByFnameAndPosition(fname,posid));
    }

    @GetMapping("/find/fname/{fname}/dept/{deptid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByfnameAndDept(@PathVariable(value = "fname") String fname,@PathVariable(value = "deptid") Integer deptid){
        return ResponseEntity.ok().body(employeeService.getEmloyeeByFnameAndDepartment(fname,deptid));
    }

    @GetMapping("/find/fname/{fname}/dept/{deptid}/pos/{posid}")
    @CrossOrigin("*")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployeeByfnameAndDeptAndPos(@PathVariable(value = "fname") String fname,@PathVariable(value = "deptid") Integer deptid,@PathVariable(value = "posid") Integer posid){
        return ResponseEntity.ok().body(employeeService.getEmloyeeByFnameAndDepartmentAndPosition(fname, deptid, posid));
    }
    /*[End]==========================---Multiple Search---==========================*/
}
