package developer;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import exception.InvalidEmployeeId;
import interfaces.ITest;
import character.Employee;
import projects.Project;

public class   QualityAssurance extends Employee implements ITest {
    private boolean isManual;
    private Project projects;

    public QualityAssurance(String fistNameEnter, String lastNameEnter, int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel, boolean isManual, Project projects) throws InvalidEmployeeId {
        super(fistNameEnter, lastNameEnter, employeeIdEnter, gender, department, contractType, experienceLevel);
        this.isManual = isManual;
        this.projects = projects;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    @Override
    public void test() {
        if (isManual){
            System.out.println("I can do manual work for testing");
        } else {
            System.out.println("I can run automated code");
        }

    }


     @Override
    public String toString() {
        return "QualityAssurance{" +
                "FullName='" + firstName +  " " + lastName + '\'' +
                ", Gender='"  + gender +
                ", employeeId=" + employeeId +
                ", " + department +
                ", contractType=" + contractType +
                ", experienceLevel=" + experienceLevel +
                ", " + projects +
                "isManual=" + isManual +
                '}';
    }

}
