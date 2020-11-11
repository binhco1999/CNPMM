package com.macia.HRs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Data
@EqualsAndHashCode(exclude = {"USR_ID"})
@NoArgsConstructor
@AllArgsConstructor

public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Integer USR_ID;

    @Column(name = "FullName", length = 100, nullable = false)
    private String fullName;

    @Column(name = "UserName", length = 15, nullable = false, unique = true)
    private String UserName;

    @Column(name = "Password", length = 15, nullable = false)
    private String Password;
}