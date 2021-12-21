package id.oneindoensia.javabootcamp.day6.springrest.service;

import id.oneindoensia.javabootcamp.day6.springrest.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

}
