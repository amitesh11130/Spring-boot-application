package com.ak.services;

import com.ak.entity.Employee;
import com.ak.repositories.EmployeeDAO;
import com.ak.request.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService (EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    public void save(EmployeeDTO employeeDTO) {
        employeeDAO.save(employeeDTO);
    }

    public List<Employee> findAll() {
       return employeeDAO.findAll();
    }
}
