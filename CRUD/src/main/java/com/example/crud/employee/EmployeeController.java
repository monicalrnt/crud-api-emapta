package com.example.crud.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Will have all of the Resources for API
@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping //CREATE
    public void registerNewEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @GetMapping //RETRIEVE
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PutMapping(path = "{employeeId}") //UPDATE
    public void updateEmployee(
            @PathVariable("employeeId") Long employeeId,
            @RequestParam(required = false) String nationality,
            @RequestParam(required = false) String civilStatus) {
        employeeService.updateEmployee(employeeId, nationality, civilStatus);
    }

    @DeleteMapping (path = "{employeeId}") //DELETE
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId){
        employeeService.deleteEmployee (employeeId);
    }

}
