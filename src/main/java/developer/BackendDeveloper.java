package developer;
import departments.Department;
import departments.HumanResourceDepartment;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import enums.ProgramingLanguages;
import exception.InvalidEmployeeId;
import interfaces.ICode;
import character.Employee;
import projects.Project;
import org.apache.log4j.Logger;
public class  BackendDeveloper extends Employee implements ICode {
    public static Logger logger = Logger.getLogger(BackendDeveloper.class);
    private Project projects;

    private ProgramingLanguages programingLanguages;

    public BackendDeveloper(String fistNameEnter, String lastNameEnter, int age,int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel, Project projects, ProgramingLanguages programingLanguages,double salary ) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, employeeIdEnter,age, gender, department, contractType, experienceLevel, salary);
        this.projects = projects;
        this.programingLanguages = programingLanguages;
    }

    @Override
    public void code() {

    }


  @Override
    public String toString() {
        return "BackendDeveloper{" +
                "FullName='" + firstName +" " + lastName + '\'' +
                ", gender=" + gender +
                ", employeeId=" + employeeId +
                 ", " + department +
                ", contractType=" + contractType +
                ", experienceLevel=" + experienceLevel +
                ", " + projects +
                ",programingLanguage='" + programingLanguages + '\'' +
                '}';
    }

}
