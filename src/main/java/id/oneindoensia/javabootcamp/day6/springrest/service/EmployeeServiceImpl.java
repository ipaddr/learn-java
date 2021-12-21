package id.oneindoensia.javabootcamp.day6.springrest.service;

import id.oneindoensia.javabootcamp.day6.springrest.dao.EmployeeSpringDataJPARepository;
import id.oneindoensia.javabootcamp.day6.springrest.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
//    @Qualifier("employeeDAOJpaImpl")
    private EmployeeSpringDataJPARepository employeeDAO;

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId).get();
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }

}
