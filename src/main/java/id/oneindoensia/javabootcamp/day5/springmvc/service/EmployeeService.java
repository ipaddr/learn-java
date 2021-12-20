package id.oneindoensia.javabootcamp.day5.springmvc.service;

import id.oneindoensia.javabootcamp.day5.springmvc.model.Employee;
import id.oneindoensia.javabootcamp.day5.springmvc.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void insert(Employee employee){
        employeeRepository.insertEmployeeToDB(employee);
    }

    public void update(Employee employee){
        employeeRepository.updateEmployeeOnDB(employee);
    }

    public void delete(int employeeId){
        employeeRepository.deleteEmployeeOnDB(employeeId);
    }

    public Employee findTheEmployee(int employeeId){
        return employeeRepository.findEmployeeWithId(employeeId);
    }

    public List<Employee> allEmployees(){
        return employeeRepository.findAllEmployeesFromDB();
    }
}
