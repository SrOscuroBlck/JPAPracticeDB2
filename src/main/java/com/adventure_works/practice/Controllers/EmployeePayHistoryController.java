package com.adventure_works.practice.Controllers;

import com.adventure_works.practice.Models.EmployeePayHistoryModel;
import com.adventure_works.practice.Repositories.IEmployeePayHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeePayHistoryController {
    @Autowired
    private IEmployeePayHistoryRepository employeePayHistoryRepository;

    //    JPA Operators
    @GetMapping("/employeePayHistory/ByEmployeeNationalIDNumber")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeNationalIDNumber(@RequestParam String nationalIDNumber) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_NationalIDNumber(nationalIDNumber);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByEmployeeLoginID")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeLoginID(@RequestParam String loginID) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_LoginID(loginID);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByEmployeeJobTitle")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeJobTitle(@RequestParam String jobTitle) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_JobTitle(jobTitle);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByEmployeeSalariedFlagTrue")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeSalariedFlagTrue() {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_SalariedFlagTrue();

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByEmployeeSalariedFlagFalse")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeSalariedFlagFalse() {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_SalariedFlagFalse();

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByEmployeeVacationHoursGreaterThan")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeVacationHoursGreaterThan(@RequestParam Short vacationHours) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_VacationHoursGreaterThan(vacationHours);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByEmployeeVacationHoursEquals")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByEmployeeVacationHoursEquals(@RequestParam Short vacationHours) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByEmployee_VacationHoursEquals(vacationHours);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByRateEquals")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByRateEquals(@RequestParam BigDecimal rate) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByRateEquals(rate);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByRateBetween")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByRateBetween(@RequestParam BigDecimal minRate, @RequestParam BigDecimal maxRate) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByRateBetween(minRate, maxRate);

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/ByModifiedDateAfter")
    public ResponseEntity<List<EmployeePayHistoryModel>> getEmployeePayHistoryByModifiedDateAfter(@RequestParam String date) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findByModifiedDateAfter(LocalDateTime.parse(date));

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Native Queries

    @GetMapping("/employeePayHistory/AllPayHistoriesWithinDateRange")
    public ResponseEntity<List<EmployeePayHistoryModel>> getAllPayHistoriesWithinDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        try {
            List<EmployeePayHistoryModel> employeePayHistories = employeePayHistoryRepository.findAllPayHistoriesWithinDateRange(LocalDateTime.parse(startDate), LocalDateTime.parse(endDate));

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/MaxPayRateForEmployees")
    public ResponseEntity<List<Object[]>> getMaxPayRateForEmployees() {
        try {
            List<Object[]> employeePayHistories = employeePayHistoryRepository.findMaxPayRateForEmployees();

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/MinPayRateForEmployees")
    public ResponseEntity<List<Object[]>> getMinPayRateForEmployees() {
        try {
            List<Object[]> employeePayHistories = employeePayHistoryRepository.findMinPayRateForEmployees();

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/AveragePayRateByJobTitle")
    public ResponseEntity<List<Object[]>> getAveragePayRateByJobTitle() {
        try {
            List<Object[]> employeePayHistories = employeePayHistoryRepository.calculateAveragePayRateByJobTitle();

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeePayHistory/MaxPayRateByJobTitle")
    public ResponseEntity<List<Object[]>> getMaxPayRateByJobTitle() {
        try {
            List<Object[]> employeePayHistories = employeePayHistoryRepository.findMaxPayRateByJobTitle();

            if (employeePayHistories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employeePayHistories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
