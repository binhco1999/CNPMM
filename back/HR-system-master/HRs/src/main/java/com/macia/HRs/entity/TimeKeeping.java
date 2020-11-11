package com.macia.HRs.entity;

import com.macia.HRs.DTO.TimeKeepingDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "named_syncDataOnDate",
                procedureName = "sync_Data_On_Date",
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "date",
                                type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "named_getTimeKeepingByDateAndDepId",
                procedureName = "get_TimeKeeping_Data_By_Date_And_DepId",
                resultSetMappings = "TimeKeepingMapping",
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "date",
                                type = String.class),
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "depid",
                                type = Integer.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "named_getTimeKeepingByDate",
                procedureName = "get_TimeKeeping_Data_By_Date",
                resultSetMappings = "TimeKeepingMapping",
                parameters = {
                        @StoredProcedureParameter(
                                mode = ParameterMode.IN,
                                name = "date",
                                type = String.class)
                }
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
            name="TimeKeepingMapping",
            classes = {
                    @ConstructorResult(targetClass = TimeKeepingDTO.class,
                        columns = {
                            @ColumnResult(name="tkp_id",type = Integer.class),
                            @ColumnResult(name="fullname", type = String.class),
                            @ColumnResult(name="checktime",type = String.class),
                            @ColumnResult(name="shift_name",type = String.class),
                            @ColumnResult(name="type",type = String.class)
                    }
            )}
        ),
})
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"TKP_ID"})
@ToString(exclude = {"employee"})
@NamedQueries({
})
public class TimeKeeping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TKP_ID")
    private Integer TKP_ID;

    @Column(name = "timeCheckCodeOfEmp")
    private Integer timeCheckCodeOfEmp;

    @Column(nullable = false, name = "DateTime")
    private LocalDateTime DateTime;

    @Column(nullable = false, name = "Reader")
    private Integer reader;

    @Column(nullable = false, name = "EventData")
    private Integer eventData;


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

    @Column()
    private Integer nEventLogIdn;

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Employee employee;
}