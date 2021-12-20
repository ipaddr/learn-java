package id.oneindoensia.javabootcamp.day5.springmvc.repository;

import id.oneindoensia.javabootcamp.day5.springmvc.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmployeeRepository {

    private TreeMap<Integer, Employee> employeeMap = new TreeMap<>();

    public EmployeeRepository(){
        Employee employee = new Employee(1, "John", "Doe", "johndoe@domain.com");
        Employee employee2 = new Employee(2, "Adam", "Noah", "adamnoah@domain.com");
        Employee employee3 = new Employee(3, "Sarah", "Allen", "sarahallen@domain.com");
        employeeMap.put(employee.getId(), employee);
        employeeMap.put(employee2.getId(), employee2);
        employeeMap.put(employee3.getId(), employee3);
    }

    public void insertEmployeeToDB(Employee employee){
        employee.setId(employeeMap.lastKey() + 1);
        employeeMap.put(employee.getId(), employee);
    }

    public void updateEmployeeOnDB(Employee employee){
        employeeMap.put(employee.getId(), employee);
    }

    public void deleteEmployeeOnDB(int employeeId){
        employeeMap.remove(employeeId);
    }

    public Employee findEmployeeWithId(int employeeId){
        return employeeMap.get(employeeId);
    }

    public List<Employee> findAllEmployeesFromDB(){
        return employeeMap.values().stream().toList();
    }

}
