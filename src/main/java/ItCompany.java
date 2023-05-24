import enums.DepartmentList;
import interfaces.IPrintInfo;
import departments.Department;
import java.util.ArrayList;
//import

public final class ItCompany implements IPrintInfo {
    private static String companyName;
    private static String address;
  // private enums.DepartmentList departmentList;

    private final ArrayList<Department> DepartmentList = new ArrayList<>();

    public ItCompany(String companyNameEnter, String addressEnter) { //ArrayList<Department> departmentListEnter) {
        this.companyName = companyNameEnter;
        this.address = addressEnter;
        //this.DepartmentList=departmentList;

    }

    public void addDepartment(Department deptObjectEnter) {
        DepartmentList.add(deptObjectEnter);
    }

    public ArrayList<Department> getDepartmentList() {
        return DepartmentList;
    }



    static {
        companyName = "AIN Technologies ";
        address = " 24th street N, Alexander MD";
        System.out.println( companyName + " Address " + address);
       // System.out.println("AIN Technologies Department List ");

    }


    @Override
    public void printInformation() {

       // System.out.println(getCompanyName() + " Address " + getAddress());
      //  System.out.println("AIN Technologies Department List ");

    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}



