package departments;
import departments.Department;
import character.Employee;
import exception.SocialSecurityLengthException;
import exception.NullDepartmentException;
import exception.SocialSecurityLengthException;
import interfaces.IPrintInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class HumanResourceDepartment extends Department implements IPrintInfo {

    protected List<Boolean> positionStatuses;
    protected String socialSecurity;




    public HumanResourceDepartment(String departmentName, int departmentId,String socialSecurityEnter ) throws NullDepartmentException {
        super(departmentName, departmentId);
        positionStatuses = new ArrayList<>();
        this.socialSecurity = socialSecurityEnter;

    }

    public void addPosition(boolean isOpen) {
        positionStatuses.add(isOpen);
    }

    public int countOpenPositions() {
        int count = 0;
        for (boolean isOpen : positionStatuses) {
            if (isOpen) {
                count++;
            }
        }
        return count;

    }

    public void setSocialSecurity(String socialSecurity){
        if(socialSecurity.length() !=6){
            throw new SocialSecurityLengthException("Invalid Social Security, social Security is 6 digit number.");
        }

        this.socialSecurity = socialSecurity;
    }

    @Override
    public String toString() {
        return "HumanResourceDepartment{" + getEmployeesList() +
                "positionStatuses=" + positionStatuses +
                ", socialSecurity='" + socialSecurity + '\'' +
                '}';
    }
    @Override
    public void printInformation() {
        super.printInformation();

    }

}














