package com.adventure_works.practice.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@IdClass(EmployeePayHistoryId.class)
@Table(name = "EmployeePayHistory", schema = "HumanResources")
public class EmployeePayHistoryModel {
    @Id
    @Column(name = "BusinessEntityID")
    private Integer businessEntityID; // Direct mapping for part of the composite key

    @Id
    @Column(name = "RateChangeDate")
    private LocalDateTime rateChangeDate;

    @Column(name = "Rate")
    private BigDecimal rate;

    @Column(name = "PayFrequency")
    private Short payFrequency;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BusinessEntityID")
    @JsonBackReference
    private EmployeeModel employee; // This should not be marked with @Id
}