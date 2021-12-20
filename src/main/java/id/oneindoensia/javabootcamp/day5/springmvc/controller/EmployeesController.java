package id.oneindoensia.javabootcamp.day5.springmvc.controller;

import id.oneindoensia.javabootcamp.day5.springmvc.model.Employee;
import id.oneindoensia.javabootcamp.day5.springmvc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // crete employees
//        Employee employee = new Employee(1, "John", "Doe", "johndoe@domain.com");
//        Employee employee2 = new Employee(2, "Adam", "Noah", "adamnoah@domain.com");
//        Employee employee3 = new Employee(3, "Sarah", "Allen", "sarahallen@domain.com");

        // add to list
        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(employee);
//        employeeList.add(employee2);
//        employeeList.add(employee3);

        // get date from service
//        employeeList.clear();
        employeeList.addAll(employeeService.allEmployees());

        // setup model
        theModel.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/add")
    public String addEmployee(Model theModel){

        // create employee model
        Employee employee = new Employee();

        theModel.addAttribute("employee", employee);

        return "employees/employee-insert-form";
    }

    @PostMapping("/added")
    public String addedEmployee(@Valid @ModelAttribute("employee") Employee employee,
                                BindingResult bindingResult, Model theModel){

        // validate
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        // validate
        if (constraintViolations.size() > 0){
            theModel.addAttribute("beanValidation", constraintViolations);
            return "employees/employee-insert-form";
        }

        // save the employee
        employeeService.insert(employee);

        // redirect to employee list
        return "redirect:/employees/list";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int employeeId, Model theModel){

        // get employee
        Employee employee = employeeService.findTheEmployee(employeeId);

        // pass employee to model
        theModel.addAttribute("employee", employee);

        // return view
        return "employees/employee-update-form";
    }

    @PostMapping("/updated")
    public String updatedEmployee(@ModelAttribute("employee") Employee employee){

        // save the employee
        employeeService.update(employee);

        // redirect to employee list
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id){

        // delete the employee
        employeeService.delete(id);

        // redirect to employees/list
        return "redirect:/employees/list";
    }

}
