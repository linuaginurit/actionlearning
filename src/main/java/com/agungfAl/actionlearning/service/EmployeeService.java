package com.agungfAl.actionlearning.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agungfAl.actionlearning.entity.Employee;
import com.agungfAl.actionlearning.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public Employee update(Employee newEmp, Long id) {
        return repo.findById(id)
                .map(emp -> {
                    emp.setName(newEmp.getName());
                    emp.setActive(newEmp.isActive());
                    emp.setRole(newEmp.getRole());
                    return repo.save(emp);
                })
                .orElseGet(() -> {
                    newEmp.setId(id);
                    return repo.save(newEmp);
                });
    }
    public List<Employee> findUser(){
        return repo.findUser();
    }
}

