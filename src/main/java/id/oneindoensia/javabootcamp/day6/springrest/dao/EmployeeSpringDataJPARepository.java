package id.oneindoensia.javabootcamp.day6.springrest.dao;

import id.oneindoensia.javabootcamp.day6.springrest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeSpringDataJPARepository extends JpaRepository<Employee, Integer> {
    // no code
}
