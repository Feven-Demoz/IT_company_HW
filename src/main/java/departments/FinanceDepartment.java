package departments;

import exception.NullDepartmentException;
import interfaces.IPrintInfo;
import org.apache.log4j.Logger;

public class  FinanceDepartment extends Department implements IPrintInfo {
    public static Logger logger = Logger.getLogger(FinanceDepartment.class);
    protected double budget;

    public FinanceDepartment(String departmentName, int departmentId, double budget) throws NullDepartmentException {
       super(departmentName, departmentId);
        this.budget = budget;
    }

    public double getBudget() {

        return budget;
    }

    public void setBudget(double budget) {

        this.budget = budget;
    }

    @Override
    public void printInformation() {super.printInformation();
        System.out.println();
    }
    @Override
    public String toString() {
        return "FinanceDepartment{" +
                "budget Set for coming year='" + budget + '\'' +
                '}';
    }
}
