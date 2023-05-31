package departments;

import exception.NullDepartmentException;
import interfaces.IPrintInfo;
import character.Employee;
import character.Manager;
import java.util.ArrayList;
import org.apache.log4j.Logger;
public class Department implements IPrintInfo  {
    public static Logger logger = Logger.getLogger(Department.class);
    private final String departmentName;
    private final int departmentId;

    private ArrayList<Employee> employeesList = new ArrayList<>();
    private ArrayList<Manager> managersList = new ArrayList<>();

    public Department(String departmentNameEnter, int departmentId) throws NullDepartmentException { //,String projectNameEnter, int startDateEnter, int finishDateEnter) {
        //super(projectNameEnter, startDateEnter, finishDateEnter);
       // if (departmentNameEnter == null){
           // throw new NullDepartmentException("Department can not be null.");
        //}
        this.departmentName = departmentNameEnter;
        this.departmentId = departmentId;

    }
    public void controlDepartment() throws NullDepartmentException {
        if (departmentName == null || departmentName.isEmpty()) {
            throw new NullDepartmentException("Department name cannot be null or empty.");
        }
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public ArrayList<Manager> getManagersList() {
        return managersList;
    }
    
    public void setEmployeesList(ArrayList<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public void setManagersList(ArrayList<Manager> managersList) {
        this.managersList = managersList;
    }

    public void addEmployee(Employee empObjectEnter) {
        employeesList.add(empObjectEnter);
    }

    public void addManager(Manager managerObjectEnter) {
        managersList.add(managerObjectEnter);
    }


    @Override
    public void printInformation() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }

}
