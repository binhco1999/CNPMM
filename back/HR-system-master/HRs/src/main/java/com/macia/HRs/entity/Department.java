package com.macia.HRs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@EqualsAndHashCode(exclude = {"DEP_ID"})
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "department_findAllAvailable",
                query = "SELECT d FROM Department d where d.isdeleted=false"),
        @NamedQuery(name = "department_findByName",
                query = "SELECT d FROM Department d WHERE d.departmentName = :deptname"),
        @NamedQuery(name = "department_findAllDepartmentByName",
                query = "from Department d where LOWER(d.departmentName) like '%' || :deptname ||'%'"),
})

public class Department implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEP_ID")
    private Integer DEP_ID;

    @Column(name = "DepartmentName", length = 50, unique = true)
    private String departmentName;

    private LocalDate startDate;

    @CreationTimestamp
    @Column(name = "CreateDate")
    private LocalDateTime createdate;

    @Column(name = "CreateBy")
    private Integer createby;

    @UpdateTimestamp
    @Column(name = "ModifyDate")
    private LocalDateTime modifyDate;

    @Column(name = "ModifyBy")
    private Integer modifyBy;

    @Column(name = "isDeleted")
    private Boolean isdeleted;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "department",
            fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Employee> employees;

}
