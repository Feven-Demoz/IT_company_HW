package departments;
import java.util.List;

import exception.NullDepartmentException;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class EngineeringDepartment extends Department  {
    public static Logger logger = Logger.getLogger(EngineeringDepartment.class);
    private List<String> equipment;

    public EngineeringDepartment(String departmentName, int departmentId,List<String> equipment ) throws NullDepartmentException {
        super(departmentName, departmentId);
        this.equipment = equipment;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Engineering Department {" +
                "equipment needed ='" + equipment +
                '}';
    }
}


