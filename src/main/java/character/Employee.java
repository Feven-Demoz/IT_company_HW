package character;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import exception.InvalidEmployeeId;
import interfaces.IPrintInfo;
import interfaces.IWork;
import java.util.Objects;
import java.util.Scanner;

public class Employee extends Person implements IWork, IPrintInfo {

    protected  int employeeId;
    protected Department department;
    protected ContractType contractType;
    protected ExperienceLevel experienceLevel;
    protected static int numberOfEmployee = 0;

    public Employee(String fistNameEnter, String lastNameEnter, int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, gender);
        //setEmployeeId(employeeId);
         if (employeeIdEnter == 0) {
          throw new InvalidEmployeeId("All employees must have ID number");
         }
        this.employeeId = employeeIdEnter;
        this.department = department;
        this.gender = gender;
        this.contractType = contractType;
        this.experienceLevel = experienceLevel;
        numberOfEmployee++;
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
