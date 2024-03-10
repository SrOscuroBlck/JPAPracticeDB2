package com.adventure_works.practice.Repositories;

import com.adventure_works.practice.Models.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeModel, Integer> {
    //    JPA Operators
    List<EmployeeModel> findByPayHistories_PayFrequency(Short payFrequency);
    List<EmployeeModel> findByPayHistories_RateGreaterThan(BigDecimal rate);
    List<EmployeeModel> findByPayHistories_RateEquals(BigDecimal rate);
    List<EmployeeModel> findByPayHistories_RateLessThan(BigDecimal rate);
    List<EmployeeModel> findByPayHistories_RateChangeDateBetween(LocalDateTime start, LocalDateTime end);
    List<EmployeeModel> findByPayHistories_RateChangeDateAfter(LocalDateTime start);
    List<EmployeeModel> findByPayHistories_RateChangeDateBefore(LocalDateTime end);
    EmployeeModel findByNationalIDNumber(String nationalIDNumber);
    EmployeeModel findByLoginID(String loginID);
    EmployeeModel findByBusinessEntityID(Integer businessEntityID);

    //    Native Queries for complex operations
    @Query(value = "SELECT e.*, ep.* FROM HumanResources.Employee e INNER JOIN HumanResources.EmployeePayHistory ep ON e.BusinessEntityID = ep.BusinessEntityID WHERE ep.RateChangeDate = (SELECT MAX(ep2.RateChangeDate) FROM HumanResources.EmployeePayHistory ep2 WHERE ep2.BusinessEntityID = ep.BusinessEntityID)", nativeQuery = true)
    List<Object[]> findEmployeesWithLatestPayHistory();

    @Query(value = "SELECT e.* FROM HumanResources.Employee e JOIN HumanResources.EmployeePayHistory ep ON e.BusinessEntityID = ep.BusinessEntityID WHERE e.JobTitle = ?1 AND ep.Rate > ?2", nativeQuery = true)
    List<EmployeeModel> findEmployeesByJobTitleAndMinRate(String jobTitle, BigDecimal minRate);


    @Query(value = "SELECT e.JobTitle, COUNT(*) FROM HumanResources.Employee e GROUP BY e.JobTitle", nativeQuery = true)
    List<Object[]> countEmployeesByJobTitle();

    @Query(value = "SELECT e.JobTitle, AVG(ep.Rate) AS AvgRate FROM HumanResources.Employee e JOIN HumanResources.EmployeePayHistory ep ON e.BusinessEntityID = ep.BusinessEntityID GROUP BY e.JobTitle", nativeQuery = true)
    List<Object[]> findAveragePayByJobTitle();

    @Query(value = "SELECT * FROM HumanResources.Employee WHERE HireDate > ?1 ORDER BY HireDate ASC", nativeQuery = true)
    List<EmployeeModel> findEmployeesHiredAfter(LocalDate date);

}
