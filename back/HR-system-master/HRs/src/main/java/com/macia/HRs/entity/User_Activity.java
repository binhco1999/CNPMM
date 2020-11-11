package com.macia.HRs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@EqualsAndHashCode(exclude = {"URA_ID"})
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "useractivity_findAll",
                query = "SELECT ura FROM User_Activity ura"),
        @NamedQuery(name = "useractivity_findAllAvailable",
                query = "SELECT ura FROM User_Activity ura where ura.isdeleted=false"),
})

public class User_Activity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "URA_ID")
    private Integer URA_ID;

    private Integer USR_ID;

    @Column(name = "ActivityName", length = 500)
    private String activityName;

    private LocalDateTime datetime;

    @UpdateTimestamp
    @Column()
    private LocalDateTime deleteDate;

    @Column()
    private Integer deleteBy;

    @Column()
    private Boolean isdeleted;
}
