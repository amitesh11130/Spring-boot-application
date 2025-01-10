package com.ak.controller;

import com.ak.entity.Employee;
import com.ak.request.EmployeeDTO;
import com.ak.response.Meta;
import com.ak.response.ResponseDTO;
import com.ak.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/api/v1")
public class EmployeeController {


    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/add")
    public void addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @GetMapping("/get")
    public ResponseDTO getAllEmployee() {
        List<Employee> employeeList = employeeService.findAll();
        Meta meta = Meta.builder().code(String.valueOf(HttpStatus.OK)).message("Retrieve").build();
        return ResponseDTO.builder().meta(meta).data(employeeList).build();
    }

}
