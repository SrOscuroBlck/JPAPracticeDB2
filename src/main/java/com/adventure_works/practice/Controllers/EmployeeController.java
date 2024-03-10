package com.adventure_works.practice.Controllers;

import com.adventure_works.practice.Models.EmployeeModel;
import com.adventure_works.practice.Repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private IEmployeeRepository employeeRepository;

    //    JPA Operators
    @GetMapping("/employees/ByPayFrequency")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByPayFrequency(@RequestParam Short payFrequency) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_PayFrequency(payFrequency);

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByRateGreaterThan")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByRateGreaterThan(@RequestParam BigDecimal rate) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_RateGreaterThan(rate);

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByRateEquals")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByRateEquals(@RequestParam BigDecimal rate) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_RateEquals(rate);

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByRateLessThan")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByRateLessThan(@RequestParam BigDecimal rate) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_RateLessThan(rate);

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByRateChangeDateBetween")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByRateChangeDateBetween(@RequestParam String start, @RequestParam String end) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_RateChangeDateBetween(LocalDateTime.parse(start), LocalDateTime.parse(end));

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByRateChangeDateAfter")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByRateChangeDateAfter(@RequestParam String start) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_RateChangeDateAfter(LocalDateTime.parse(start));

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByRateChangeDateBefore")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByRateChangeDateBefore(@RequestParam LocalDateTime end) {
        try {
            List<EmployeeModel> employees = employeeRepository.findByPayHistories_RateChangeDateBefore(end);

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByNationalIDNumber")
    public ResponseEntity<EmployeeModel> getEmployeeByNationalIDNumber(@RequestParam String nationalIDNumber) {
        try {
            EmployeeModel employee = employeeRepository.findByNationalIDNumber(nationalIDNumber);

            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByLoginID")
    public ResponseEntity<EmployeeModel> getEmployeeByLoginID(@RequestParam String loginID) {
        try {
            EmployeeModel employee = employeeRepository.findByLoginID(loginID);

            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByBusinessEntityID")
    public ResponseEntity<EmployeeModel> getEmployeeByBusinessEntityID(@RequestParam Integer businessEntityID) {
        try {
            EmployeeModel employee = employeeRepository.findByBusinessEntityID(businessEntityID);

            if (employee == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //    Native Queries
    @GetMapping("/employees/WithLatestPayHistory")
    public ResponseEntity<List<Object[]>> getEmployeesWithLatestPayHistory() {
        try {
            List<Object[]> employees = employeeRepository.findEmployeesWithLatestPayHistory();

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/ByJobTitleAndMinRate")
    public ResponseEntity<List<EmployeeModel>> getEmployeesByJobTitleAndMinRate(@RequestParam String jobTitle, @RequestParam BigDecimal minRate) {
        try {
            List<EmployeeModel> employees = employeeRepository.findEmployeesByJobTitleAndMinRate(jobTitle, minRate);

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/CountByJobTitle")
    public ResponseEntity<List<Object[]>> countEmployeesByJobTitle() {
        try {
            List<Object[]> employees = employeeRepository.countEmployeesByJobTitle();

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/AveragePayByJobTitle")
    public ResponseEntity<List<Object[]>> findAveragePayByJobTitle() {
        try {
            List<Object[]> employees = employeeRepository.findAveragePayByJobTitle();

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/HiredAfter")
    public ResponseEntity<List<EmployeeModel>> findEmployeesHiredAfter(@RequestParam String date) {
        try {
            List<EmployeeModel> employees = employeeRepository.findEmployeesHiredAfter(LocalDate.parse(date));

            if (employees.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
