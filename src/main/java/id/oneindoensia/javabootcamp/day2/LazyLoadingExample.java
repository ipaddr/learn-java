package id.oneindoensia.javabootcamp.day2;

import java.util.ArrayList;
import java.util.List;

class Employee{
    String employeeName;
    double employeeSalary;

    public Employee(String employeeName, double employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String toString()
    {
        return "Employee Name: " + employeeName + ", "+
                "Employee Salary : " + employeeSalary;
    }
}

interface ContactList{
    public List<Employee> getEmployeeList();
}

class Company {
    String companyName;
    String companyAddress;
    String companyPhone;
    ContactList contactList;

    public Company(String companyName, String companyAddress, String companyPhone, ContactList contactList) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyPhone = companyPhone;
        this.contactList = contactList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public ContactList getContactList() {
        return contactList;
    }

    public void setContactList(ContactList contactList) {
        this.contactList = contactList;
    }
}

class ContactListImpl implements ContactList{

    @Override
    public List<Employee> getEmployeeList() {
        return getEmptyList();
    }

    private static List<Employee> getEmptyList(){
        List<Employee> empList = new ArrayList<>(5);

        empList.add(new Employee("Alex", 7694829.373));
        empList.add(new Employee("Bob", 7257439.483));
        empList.add(new Employee("Castro", 8256873.7337));
        empList.add(new Employee("Doe", 8875489.54434));
        empList.add(new Employee("Enel", 9843347.0431));

        return empList;
    }
}

class ContactListProxyImpl implements ContactList{
    private ContactList contactList;
    public List<Employee> getEmployeeList(){
        if (contactList == null){
            System.out.println("ambil data list employee");
            contactList = new ContactListImpl();
        }
        return contactList.getEmployeeList();
    }
}


public class LazyLoadingExample {
    public static void main(String[] args) {
        ContactList contactList = new ContactListProxyImpl();
        Company company = new Company
                ("One Indonesia", "Jakarta"
                        , "62-111-1234567689", contactList);

        System.out.println("Company Name: " + company.getCompanyName());
        System.out.println("Company Address: " + company.getCompanyAddress());
        System.out.println("Company Contact No.: " + company.getCompanyPhone());
        System.out.println("inisialisasi contactlist disini...");

        contactList = company.getContactList();
        List<Employee> empList = contactList.getEmployeeList();
        for (Employee emp : empList) {
            System.out.println(emp);
        }
    }
}
