import character.Employee;
import departments.Department;
import departments.HumanResourceDepartment;
import departments.FinanceDepartment;
import departments.EngineeringDepartment;
import developer.BackendDeveloper;
import developer.FrontendDeveloper;
import developer.QualityAssurance;
import character.Manager;
import character.Client;
import enums.*;
import exception.*;
import interfaces.ICheckName;
import interfaces.ICheckSSN;
import projects.Project;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

import fileReaderFolder.FileReader;
import genericLinkedList.LicenseLinkedList;
//import java.awt.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidEmployeeId, NullDepartmentException {


        ItCompany itObject = new ItCompany("AIN Technologies", "24th street N, Alexander MD");

        //itObject.printInformation();

        try {
            List<Department> departmentList = Arrays.asList(new Department("Sales Department", 9087),
                    new Department("Marketing Department", 9086));
            //departmentList.stream().forEach(System.out::println);

            for (Department departmentObject : departmentList) {
                System.out.println(departmentObject);
            }
        } catch (NullDepartmentException e) {
            //System.out.println("Error" + e.getMessage());
            logger.error("Error" + e.getMessage());
        }

        System.out.println();
        try {
            List<BackendDeveloper> backendDeveloperList = Arrays.asList(new BackendDeveloper("Amy", "Lee", 987, Gender.FEMALE, new Department("Backend Developer", 665), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, new Project("Web development", 4, 8), ProgramingLanguages.JAVA),
                    new BackendDeveloper("Mia", "Joy", 867, Gender.FEMALE, new Department("Backend Developer", 665), ContractType.INTERNSHIP, ExperienceLevel.ENTRY, new Project("API Development", 3, 9), ProgramingLanguages.JAVA));
            backendDeveloperList.stream().forEach(System.out::println);
        } catch (ProjectException e) {
            //System.out.println("Error" + e.getMessage());
            logger.error("Error" + e.getMessage());
        }
        System.out.println();
        try {
            List<FrontendDeveloper> frontendDeveloperList = Arrays.asList(new FrontendDeveloper("Adam", "Cole", 543, Gender.OTHER, new Department("Frontend Developer", 442), ContractType.FULL_TIME, ExperienceLevel.INTERMEDIATE, "Angular", new Project("Web Design 1", 4, 9)),
                    new FrontendDeveloper("Emma", "Oliver", 987, Gender.FEMALE, new Department("Frontend Developer", 442), ContractType.FULL_TIME, ExperienceLevel.INTERMEDIATE, "Vue.js", new Project("Web Design 2", 6, 9)));
            frontendDeveloperList.stream().forEach(System.out::println);
        } catch (ProjectException e) {
            //System.out.println("Error" + e.getMessage());
            logger.error("Error" + e.getMessage());
        }
        System.out.println();
        try {

            List<QualityAssurance> qualityAssuranceList = Arrays.asList(new QualityAssurance("Jack", "Oliver", 654, Gender.MALE, new Department("Quality Assurance", 224), ContractType.CONTRACTOR, ExperienceLevel.ADVANCED, false, new Project("Usability Testing", 8, 10)),
                    new QualityAssurance("Daniel", "William", 385, Gender.OTHER, new Department("Quality Assurance", 224), ContractType.FULL_TIME, ExperienceLevel.INTERMEDIATE, true, new Project("Mobile Testing ", 2, 5)));
            qualityAssuranceList.stream().forEach(System.out::println);

            System.out.println();
        } catch (ProjectException e) {
            // System.out.println("Error" + e.getMessage());
            logger.error("Error" + e.getMessage());
        }

        List<Manager> managerList = new ArrayList();
        Manager testing = new Manager("Sam", "Jon", 980, Gender.MALE, new Department("Finance Department", 546), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, "Finance Manager", 7);
        Manager testing2 = new Manager("Tom", "White", 928, Gender.MALE, new Department("Marketing Department", 321), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, "Head of Marketing", 6);

        managerList.add(testing);
        managerList.add(testing2);

        try {

            testing.controlManger();

        } catch (InvalidYearsOfExperience e) {
            logger.error("Error" + e.getMessage());
        }
        try {
            testing2.controlManger();
        } catch (InvalidYearsOfExperience e) {
            logger.error("Error" + e.getMessage());
        }
        for (Manager mangerObject : managerList) {
            logger.info(mangerObject);
        }
        System.out.println("Number of manages =" + Manager.getNumberOfManagers());
        System.out.println();


        List<Employee> employeeList = new ArrayList();
        Employee emp = new Employee("Sam", "Smith", 987, Gender.MALE, new Department("Marketing Department", 768), ContractType.FULL_TIME, ExperienceLevel.ADVANCED);
        Employee emp2 = new Employee("Mary", "Williams", 876, Gender.FEMALE, new Department("sales Department", 543), ContractType.CONTRACTOR, ExperienceLevel.INTERMEDIATE);
        employeeList.add(emp);
        employeeList.add(emp2);
        try {
            emp.controlEmployee();
        } catch (InvalidEmployeeId e) {
            logger.error("Error" + e.getMessage());
        }
        try {
            emp2.controlEmployee();
        } catch (InvalidEmployeeId e) {
            logger.error("Error" + e.getMessage());
        }
        for (Employee empObject : employeeList) {
            logger.info(empObject);
        }
        logger.info("Number of employees = " + Employee.getNumberOfEmployee());
        System.out.println();
////////lambda 1 not printing

     // Stream<Employee> employeeStream = employeeList.stream().filter(employee->employee.getDepartment().equals("sales Department") );
       // Stream<Employee> employeeStream = employeeList.stream().filter(employee->employee.getFirstName().equals("Sam") );
        Stream<Employee> employeeStream = employeeList.stream().filter(employee->employee.getEmployeeId() ==987  );
        employeeStream.forEach(Employee-> logger.info(Employee.getFirstName() + " " + Employee.getLastName()));
      //  Stream<Employee> employeeStream = employeeList.stream().filter(employee->employee.getGender().equals("MALE") );
       // employeeStream.forEach(Employee-> System.out.println(Employee.getFirstName()));



        HumanResourceDepartment hrObject = new HumanResourceDepartment("HR", 749, "278765");
        hrObject.addPosition(true);
        hrObject.addPosition(false);
        hrObject.addPosition(true);

        int openPositions = hrObject.countOpenPositions();
        //System.out.println("HumanResource Department {" + openPositions + " positions open }");
        logger.info("HumanResource Department {" + openPositions + " positions open }");
        try {

            hrObject.setSocialSecurity("123496");
            hrObject.setSocialSecurity("876543");
            hrObject.setSocialSecurity("987659");
            //System.out.println("Social Security Number is correctly provided.");
            logger.error("Social Security Number is correctly provided.");
        } catch (SocialSecurityLengthException e) {
            //System.out.println("Error:" + e.getMessage());
            logger.error("Error" + e.getMessage());
        }

        ICheckSSN ssnString = ssn -> !ssn.matches("\\d+");
        logger.info(ssnString.validateSSN( hrObject.getSocialSecurity()));
        //System.out.println("ssn numeric value");


        List<String> equipmentList = new ArrayList<>();
        equipmentList.add("3D Printer");
        equipmentList.add("Power Supply");


        EngineeringDepartment engineerObject = new EngineeringDepartment("Engineering Department", 987, equipmentList);
        //System.out.println(engineerObject.toString());
        logger.info(engineerObject.toString());
        FinanceDepartment financeObject = new FinanceDepartment("Finance Department", 123, 20000);
        //System.out.println(financeObject.toString());
        logger.info(financeObject.toString());
        int budgetOfYear = 1000000;
        Predicate<FinanceDepartment>budgetForYear = finance -> finance.getBudget()<= budgetOfYear;
        boolean isBudgetHigher = budgetForYear.test(financeObject);

        Client<String> listClientsNames = new Client<>();
        listClientsNames.add("Ben");
        listClientsNames.add("Abel");
        listClientsNames.add("Adam");
        listClientsNames.printList();

        Client<Integer> listClientsID = new Client<>();
        listClientsID.add(1442);
        listClientsID.add(3131);
        listClientsID.add(9530);
        listClientsID.printList();


        System.out.println();
        logger.info("AIN Technologies Department List ");
        for (DepartmentList depListObject : DepartmentList.values()) {
            logger.info(depListObject.getDepartments());
        }
        FileReader fileRer = new FileReader();
        fileRer.countUniqueWords("src/main/resources/uniqueWordCount.txt");


           // LicenseLinkedList<Integer> licenseList = new LicenseLinkedList<>();
        }
    }



