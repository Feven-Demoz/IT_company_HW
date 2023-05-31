package character;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import exception.InvalidEmployeeId;
import exception.InvalidYearsOfExperience;
import interfaces.IPrintInfo;
import interfaces.IWork;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public class Employee extends Person implements IWork, IPrintInfo {
    public static Logger logger = Logger.getLogger(Employee.class);
    protected  int employeeId;
    protected Department department;
    protected ContractType contractType;
    protected ExperienceLevel experienceLevel;
    protected double salary;
    protected static int numberOfEmployee = 0;

    public Employee(String fistNameEnter, String lastNameEnter, int age,int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel,double salary) {
        super(fistNameEnter, lastNameEnter,age, gender);
        //setEmployeeId(employeeId);
         //if (employeeIdEnter == 0) {
          //throw new InvalidEmployeeId("All employees must have ID number");
        // }
        this.employeeId = employeeIdEnter;
        this.department = department;
        this.gender = gender;
        this.contractType = contractType;
        this.experienceLevel = experienceLevel;
        this.salary = salary;
        numberOfEmployee++;
    }


    public void controlEmployee() throws InvalidEmployeeId{
        if (employeeId != 0) {
            //System.out.println("Employee ID is correct");
            logger.info("Employee ID is correct");
        }else {
            throw new InvalidEmployeeId("All employees must have ID number");
        }
    }


    public int getEmployeeId() {
        return employeeId;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee list{" +
                "Full Name='" + firstName + " " + lastName + '\'' +
                ", Gender='" + gender +
                ", employeeId=" + employeeId +
                ", " + department + '\'' +
                ", contractType=" + contractType +
                ", experienceLevel=" + experienceLevel +
                '}';
    }


    @Override
    public void work() {

    }

    @Override
    public void printInformation() {
        //System.out.println("Employee " + getFirstName() + " "+ getLastName() + " with employee ID " + getEmployeeId() + " works in "+ getDepartment()+ " department");
    }

    @Override
    public void profileCheck() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getEmployeeId() == employee.getEmployeeId() && Objects.equals(getDepartment(), employee.getDepartment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getDepartment());
    }


}
