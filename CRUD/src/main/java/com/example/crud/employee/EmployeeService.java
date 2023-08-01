package com.example.crud.employee;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// Responsible for Business Logic
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // CREATE
    public void addNewEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findEmployeeByFirst_name(employee.getFirst_name());
        if (employeeOptional.isPresent()){
            throw new IllegalStateException("First Name Already Exists");
        }

        employeeRepository.save(employee);
    }

    //RETRIEVE
    public List<Employee> getEmployees() {
         return employeeRepository.findAll();
    }

    //UPDATE
    @Transactional
    public void updateEmployee(Long employeeId, String nationality, String civilStatus) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalStateException("Employee with ID:" + employeeId + " does not Exist in the Database"));

        if (nationality!= null && nationality.length() > 0 && !Objects.equals(employee.getNationality(), nationality)) {
            employee.setNationality(nationality);
        }
        if (civilStatus!= null && civilStatus.length() > 0 && !Objects.equals(employee.getCivil_status(), civilStatus)) {
            employee.setCivil_status(civilStatus);
        }
    }

    //DELETE
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId);
        boolean exists = employeeRepository.existsById(employeeId);

        if(!exists){
            throw new IllegalStateException("Employee with ID:" + employeeId + " does not Exist in the Database");
        } employeeRepository.deleteById(employeeId);
    }


}
