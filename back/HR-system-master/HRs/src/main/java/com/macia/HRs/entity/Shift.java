package com.macia.HRs.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"SIF_ID"})
@NamedQueries({
        @NamedQuery(name = "shift_findAll",
                query = "SELECT e FROM Shift e"),
        @NamedQuery(name = "shift_findAllAvailable",
                query = "SELECT e FROM Shift e where e.isDeleted=false "),
})
public class Shift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIF_ID")
    private Integer SIF_ID;

    @Column(nullable = false, unique = true, name = "ShiftCode", length = 5)
    private String shiftCode;

    @Column(nullable = false, unique = true, name = "ShiftName", length = 100)
    private String shiftName;



    @CreationTimestamp
    @Column(name = "CreateDate")
    private LocalDateTime createDate;

    @Column(name = "CreateBy")
    private Integer createBy;

    @UpdateTimestamp
    @Column(name = "ModifyDate")
    private LocalDateTime modifyDate;

    @Column(name = "ModifyBy")
    private Integer modifyBy;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;


    
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "shift",
            fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Employee_Shift> employee_shifts;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "shift",
            fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Shift_Daily> shift_dailies;
}