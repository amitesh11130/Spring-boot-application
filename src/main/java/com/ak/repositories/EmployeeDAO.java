package com.ak.repositories;

import com.ak.entity.Employee;
import com.ak.request.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAO {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeDAO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(EmployeeDTO employeeDTO) {
        Employee employee = convert(employeeDTO);
        employeeRepository.save(employee);
    }

    public Employee convert(EmployeeDTO employeeDTO){
        return Employee.builder()
                .name(employeeDTO.getName())
                .company(employeeDTO.getCompany())
                .contactNo(employeeDTO.getContactNo())
                .build();
    }
}
