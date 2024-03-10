package com.adventure_works.practice.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Employee", schema = "HumanResources")
public class EmployeeModel {
    @Id
    @Column(name = "BusinessEntityID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer businessEntityID;

    @Column(name = "NationalIDNumber", length = 15)
    private String nationalIDNumber;

    @Column(name = "LoginID", length = 256)
    private String loginID;

    @Column(name = "OrganizationNode", columnDefinition = "VARBINARY(MAX)")
    private byte[] organizationNode; // Used for storing hierarchyid as a binary array

    @Column(name = "OrganizationLevel", insertable = false, updatable = false)
    private Short organizationLevel; // Use Short for smallint type

    @Column(name = "JobTitle", length = 50)
    private String jobTitle;

    @Column(name = "BirthDate")
    private LocalDate birthDate;

    @Column(name = "MaritalStatus", columnDefinition = "nchar(1)")
    private String maritalStatus;

    @Column(name = "Gender", columnDefinition = "nchar(1)")
    private String gender;

    @Column(name = "HireDate")
    private LocalDate hireDate;

    @Column(name = "SalariedFlag", columnDefinition = "bit")
    private Boolean salariedFlag;

    @Column(name = "VacationHours")
    private Short vacationHours;

    @Column(name = "SickLeaveHours")
    private Short sickLeaveHours;

    @Column(name = "CurrentFlag", columnDefinition = "bit")
    private Boolean currentFlag;

    @Column(name = "rowguid")
    private UUID rowguid;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    // Add the one-to-many association to EmployeePayHistoryModel
    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private List<EmployeePayHistoryModel> payHistories;
}
