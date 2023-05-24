package developer;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import enums.ProgramingLanguages;
import exception.InvalidEmployeeId;
import interfaces.ICode;
import character.Employee;
import projects.Project;
public class  BackendDeveloper extends Employee implements ICode {

    private Project projects;

    private ProgramingLanguages programingLanguages;

    public BackendDeveloper(String fistNameEnter, String lastNameEnter, int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel, Project projects, ProgramingLanguages programingLanguages) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, employeeIdEnter, gender, department, contractType, experienceLevel);
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
