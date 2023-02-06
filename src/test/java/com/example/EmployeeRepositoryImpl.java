package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employeeArrayList = new ArrayList<>();

    @Override
    public List<Employee> findAll() {
        return employeeArrayList;
    }

    @Override
    public Employee save(Employee employee) {
        employeeArrayList.add(employee);
        return employee;                        //varför har vi return employee här?
    }
}
