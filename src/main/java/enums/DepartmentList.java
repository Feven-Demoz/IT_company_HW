package enums;

import javax.print.attribute.standard.MediaSize;

public enum DepartmentList {
    ENGINEERING("Engineering"),
    SOFTWARE_DEVELOPMENT("Software Development"),
    QUALITY_ASSURANCE ("Quality Assurance"),
    DATA_SCIENCE("Data Science"),
    BUSINESS_INTELLIGENCE("Business Intelligence"),
    FINANCE("Finance"),
    SALES("Sales"),
    HUMAN_RESOURCES("Human Resources"),
    CYBER_SECURITY("Cyber Security"),
    TECHNICAL_SUPPORT("Technical Support");

    private final String departments;

    DepartmentList(String departmentsEnter) {
        this.departments = departmentsEnter;
    }

    public String getDepartments() {
        return departments;
    }
    public void printInfo(){
        System.out.println("List of department in AIN Technologies " + departments);
    }
}
