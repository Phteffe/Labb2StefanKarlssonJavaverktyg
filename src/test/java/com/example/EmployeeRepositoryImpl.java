package com.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    List<Employee> myList= new ArrayList<>();
    @Override
    public List<Employee> findAll() {
        return myList;
    }

    @Override
    public Employee save(Employee e) {
        myList.add(e);
        return e;
    }
}
