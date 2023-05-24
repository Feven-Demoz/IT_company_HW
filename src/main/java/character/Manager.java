package character;
import departments.Department;
import enums.ContractType;
import enums.ExperienceLevel;
import enums.Gender;
import exception.InvalidYearsOfExperience;
import exception.InvalidEmployeeId;
import interfaces.IManage;
import interfaces.IPrintInfo;

import java.util.Objects;

public class Manager extends Employee implements IManage, IPrintInfo {
    private String title;
    private int yearsOfExperience;
private static int numberOfManagers=0;



     public Manager(String fistNameEnter, String lastNameEnter, int employeeIdEnter, Gender gender, Department department, ContractType contractType, ExperienceLevel experienceLevel,String titleEnter, int yearsOfExperienceEnter) throws InvalidEmployeeId {
                super(fistNameEnter, lastNameEnter, employeeIdEnter,gender, department, contractType, experienceLevel);
//            if (yearsOfExperienceEnter <=5 ){
//                throw new InvalidYearsOfExperience(" Managers must have 5 years or more years of experience");
//            }
            this.title = titleEnter;
            this.yearsOfExperience = yearsOfExperienceEnter;
            this.gender=gender;
            numberOfManagers++;
        }
    public void controlManger() throws InvalidYearsOfExperience {
        if (yearsOfExperience >= 5) {
            System.out.println("Employee is qualified to be manger");
        } else {
            throw new InvalidYearsOfExperience(" Employee need 5 or more years experience to be manager");
        }
    }
public static int getNumberOfManagers(){
        return numberOfManagers;
}
    public String getTitle() {
        return title;
    }

    public void setTitle(String titleEnter) {
        this.title = titleEnter;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperienceEnter) {
        this.yearsOfExperience = yearsOfExperienceEnter;
    }
    @Override
    public String toString() {
        return "Manager List{" +
                "Full Name='" + firstName + " " + lastName + '\'' +
                ", Gender='"  + gender +
                ", employeeId=" + employeeId +
                ", title='" + title + '\'' +
                ", " +  department + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                '}';
    }

    @Override
    public void manage() {

    }

    @Override
    public void printInformation() {
        super.printInformation();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return getYearsOfExperience() == manager.getYearsOfExperience() && Objects.equals(getTitle(), manager.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getYearsOfExperience());
    }
}

