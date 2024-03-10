package com.adventure_works.practice.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePayHistoryId implements Serializable {
    private Integer businessEntityID;
    private LocalDateTime rateChangeDate;
}