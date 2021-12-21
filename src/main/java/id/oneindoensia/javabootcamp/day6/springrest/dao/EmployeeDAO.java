package id.oneindoensia.javabootcamp.day6.springrest.dao;

import id.oneindoensia.javabootcamp.day6.springrest.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

}
