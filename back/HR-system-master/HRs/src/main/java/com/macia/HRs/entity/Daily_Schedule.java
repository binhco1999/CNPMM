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
import java.time.LocalTime;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"DLS_ID"})
@NamedQueries({
        @NamedQuery(name = "dailyschedule_findAllAvailable",
                query = "SELECT d FROM Daily_Schedule d where d.isdeleted=false"),
})
public class Daily_Schedule implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DLS_ID")
    private Integer DLS_ID;

    @Column(unique = true, name = "Name", length = 100,nullable = false)
    private String Name;

    @Column(nullable=false,name = "StartTime")
    private LocalTime startTime;

    @Column(nullable=false,name = "EndTime")
    private LocalTime endTime;

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
            mappedBy = "daily_schedule",
            fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Shift_Daily> shift_dailies;
}