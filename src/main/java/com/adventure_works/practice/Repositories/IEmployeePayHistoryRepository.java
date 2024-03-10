package com.adventure_works.practice.Repositories;

import com.adventure_works.practice.Models.EmployeePayHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IEmployeePayHistoryRepository extends JpaRepository<EmployeePayHistoryModel, Integer> {
    //    JPA Operators
    List<EmployeePayHistoryModel> findByEmployee_NationalIDNumber(String nationalIDNumber);
    List<EmployeePayHistoryModel> findByEmployee_LoginID(String loginID);
    List<EmployeePayHistoryModel> findByEmployee_JobTitle(String jobTitle);
    List<EmployeePayHistoryModel> findByEmployee_SalariedFlagTrue();
    List<EmployeePayHistoryModel> findByEmployee_SalariedFlagFalse();
    List<EmployeePayHistoryModel> findByEmployee_VacationHoursGreaterThan(Short vacationHours);
    List<EmployeePayHistoryModel> findByEmployee_VacationHoursEquals(Short vacationHours);
    List<EmployeePayHistoryModel> findByRateEquals(BigDecimal rate);
    List<EmployeePayHistoryModel> findByRateBetween(BigDecimal minRate, BigDecimal maxRate);
    List<EmployeePayHistoryModel> findByModifiedDateAfter(LocalDateTime date);

    //    Native Queries for complex operations
    @Query(value = "SELECT * FROM HumanResources.EmployeePayHistory WHERE RateChangeDate BETWEEN ?1 AND ?2", nativeQuery = true)
    List<EmployeePayHistoryModel> findAllPayHistoriesWithinDateRange(LocalDateTime startDate, LocalDateTime endDate);

    @Query(value = "SELECT ep.BusinessEntityID, MAX(ep.Rate) AS MaxRate FROM HumanResources.EmployeePayHistory ep GROUP BY ep.BusinessEntityID", nativeQuery = true)
    List<Object[]> findMaxPayRateForEmployees();

    @Query(value = "SELECT ep.BusinessEntityID, MIN(ep.Rate) AS MinRate FROM HumanResources.EmployeePayHistory ep GROUP BY ep.BusinessEntityID", nativeQuery = true)
    List<Object[]> findMinPayRateForEmployees();

    @Query(value = "SELECT e.JobTitle, AVG(ep.Rate) AS AvgRate FROM HumanResources.Employee e JOIN HumanResources.EmployeePayHistory ep ON e.BusinessEntityID = ep.BusinessEntityID GROUP BY e.JobTitle", nativeQuery = true)
    List<Object[]> calculateAveragePayRateByJobTitle();

    @Query(value = "SELECT e.JobTitle, MAX(ep.Rate) AS MaxRate FROM HumanResources.Employee e JOIN HumanResources.EmployeePayHistory ep ON e.BusinessEntityID = ep.BusinessEntityID GROUP BY e.JobTitle", nativeQuery = true)
    List<Object[]> findMaxPayRateByJobTitle();
}
