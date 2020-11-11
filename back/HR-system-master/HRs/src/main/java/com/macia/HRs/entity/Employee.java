package com.macia.HRs.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "named_getEmployeeLikeName",
                procedureName = "get_Employee_Like_Name",
                resultClasses = { Employee.class },
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "firstname",
                                type = String.class)
                }
        )
})


@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"EMP_ID"})
@ToString(exclude = {"department"})
@NamedQueries({
        @NamedQuery(name = "employee_findAll",
                query = "SELECT e FROM Employee e"),
        @NamedQuery(name = "employee_findByFirstName",
                query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
        @NamedQuery(name = "employee_findAllEmployeeByFirstName",
                query = "from Employee e where LOWER(e.firstName) like '%' || LOWER(:firstname) ||'%'"),
        @NamedQuery(name = "employee_findAllEmployeeByCode",
                query = "from Employee e where LOWER(e.employeeCode) like '%' || LOWER(:code) ||'%'"),
        @NamedQuery(name="employee_findAllEmployeeByDepAndPos",
                query = "from Employee e where e.department.DEP_ID=:deptid and e.position.POS_ID=:posid"),
        @NamedQuery(name="employee_findAllEmployeeByCodeAndPos",
                query = "from Employee e where LOWER(e.employeeCode) like '%' || LOWER(:code) ||'%' and e.position.POS_ID=:posid"),
        @NamedQuery(name="employee_findAllEmployeeByCodeAndDep",
                query = "from Employee e where LOWER(e.employeeCode) like '%' || LOWER(:code) ||'%' and e.department.DEP_ID=:deptid"),
        @NamedQuery(name="employee_findAllEmployeeByCodeAndDepAndPos",
                query = "from Employee e where LOWER(e.employeeCode) like '%' || LOWER(:code) ||'%' and e.department.DEP_ID=:deptid and e.position.POS_ID=:posid"),
        @NamedQuery(name="employee_findAllEmployeeByFnameAndPos",
                query = "from Employee e where LOWER(e.firstName) like '%' || LOWER(:fname) ||'%' and e.position.POS_ID=:posid"),
        @NamedQuery(name="employee_findAllEmployeeByFnameAndDep",
                query = "from Employee e where LOWER(e.firstName) like '%' || LOWER(:fname) ||'%' and e.department.DEP_ID=:deptid"),
        @NamedQuery(name="employee_findAllEmployeeByFnameAndDepAndPos",
                query = "from Employee e where LOWER(e.firstName) like '%' || LOWER(:fname) ||'%' and e.department.DEP_ID=:deptid and e.position.POS_ID=:posid")

})
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Integer EMP_ID;

    @Column(nullable = false, name = "EmployeeCode", length = 10)
    private String employeeCode;

    @Column(unique = true, name = "timeCheckCode")
    private Integer timeCheckCode;

    @Column(nullable = false, name = "FirstName", length = 20)
    private String firstName;

    @Column(nullable = false, name = "LastName", length = 20)
    private String lastName;

    @Transient
    private String fullName;

    @Column(name = "StartDate")
    private LocalDate startdate;

    @Column(name = "EndDate")
    private LocalDate enddate;

    @CreationTimestamp
    @Column(name = "CreateDate")
    private LocalDateTime createdate;

    @Column(name = "CreateBy")
    private Integer createby;

    @Column(name = "ModifyDate")
    private LocalDateTime modifyDate;

    @Column(name = "ModifyBy")
    private Integer modifyBy;

    //,columnDefinition = "Boolean default '0'"
    @Column(name = "isDeleted")
    private Boolean isdeleted;

    @ManyToOne
    @JoinColumn(name = "DEP_ID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "POS_ID")
    private Position position;


    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "employee",
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Employee_Shift> employee_shifts;


    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        return fullName.append(lastName).append(" ").append(firstName).toString();
    }
}
