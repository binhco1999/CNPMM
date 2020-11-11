package com.macia.HRs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@EqualsAndHashCode(exclude = {"HOL_ID"})
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "holiday_findAll",
                query = "SELECT d FROM Holiday d"),
        @NamedQuery(name = "holiday_findAllAvailable",
                query = "SELECT d FROM Holiday d where d.isDeleted=false "),
        @NamedQuery(name = "holiday_findByName",
                query = "SELECT d FROM Holiday d WHERE d.dayName = :dayName")
})

public class Holiday implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOL_ID")
    private Integer HOL_ID;

    @Column(name = "DayName", length = 50, unique = true)
    private String dayName;

    @Column(name = "FromDate")
    private LocalDateTime fromDate;

    @Column(name = "ToDate")
    private LocalDateTime toDate;

    @Column(name = "NumOfDayOff")
    private Float numOfDayOff;

    @Column(name = "Coefficient")
    private Float coefficient;

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
}