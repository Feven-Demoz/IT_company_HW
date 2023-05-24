package developer;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import exception.InvalidEmployeeId;
import interfaces.ICode;
import character.Employee;
import projects.Project;

public class FrontendDeveloper extends Employee implements ICode {
    private String framework;
    private Project projects;

    public FrontendDeveloper(String fistNameEnter, String lastNameEnter, int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel, String framework, Project projects) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, employeeIdEnter, gender, department, contractType, experienceLevel);
        this.framework = framework;
        this.projects = projects;
    }

    /* public FrontendDeveloper(String fistNameEnter, String lastNameEnter, int employeeIdEnter, Gender gender, Department department, String framework, Project projects) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, employeeIdEnter,gender, department);
        this.framework = framework;
        this.projects = projects;
    }*/

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    @Override
    public void code() {

    }

 @Override
    public String toString() {
        return "FrontendDeveloper{" +
                "FullName='" + firstName  +" " +  lastName + '\'' +
                ", Gender='"  + gender +
                ", employeeId=" + employeeId +
                 ", " +  department +
                 ", contractType=" + contractType +
                ", experienceLevel=" + experienceLevel +
                ", " +  projects +
                "framework='" + framework + '\'' +
                '}';
    }
}
