package developer;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import exception.InvalidEmployeeId;
import interfaces.ICode;
import character.Employee;
import org.apache.log4j.Logger;
import projects.Project;
import org.apache.log4j.Logger;
public class FrontendDeveloper extends Employee implements ICode {
    public static Logger logger = Logger.getLogger(FrontendDeveloper.class);
    private String framework;
    private Project projects;

    public FrontendDeveloper(String fistNameEnter, String lastNameEnter, int age ,int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel, String framework, Project projects,double salary) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, employeeIdEnter, age, gender, department, contractType, experienceLevel, salary);
        this.framework = framework;
        this.projects = projects;
    }

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
