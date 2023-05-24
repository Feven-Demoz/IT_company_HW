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
import projects.Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

import fileReaderFolder.FileReader;



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
        }/*

        try {
            List<Employee> employeeList = new ArrayList();
            employeeList.add(new Employee("Sam", "Smith", 0, Gender.MALE, new Department("Marketing Department", 768), ContractType.FULL_TIME, ExperienceLevel.ADVANCED));
            employeeList.add(new Employee("Mary", "Williams", 100,Gender.FEMALE ,new Department("sales Department", 543),ContractType.CONTRACTOR,ExperienceLevel.INTERMEDIATE));
            employeeList.add(new Employee("Jane", "Brown", 349,Gender.OTHER, new Department("Finance Department", 432),ContractType.PART_TIME,ExperienceLevel.ENTRY));

            for (Employee empObject : employeeList) {
                System.out.println(empObject);
            }
        } catch (InvalidEmployeeId e) {
            System.out.println("Error" + e.getMessage());

        } System.out.println("Number of employees = " + Employee.getNumberOfEmployee());

        // String inputGender = "Male";
       // try {
          //  Gender genderObject = Gender.fromString(inputGender);
          // System.out.println("gender " + genderObject.getGender());
       // } catch (IllegalArgumentException e) {
          //  System.out.println("Error:" + e.getMessage());
       // }
       // System.out.println();*/

        List<Manager> managerList = new ArrayList();
        Manager testing = new Manager("Sam", "Jon", 980, Gender.MALE, new Department("Finance Department", 546), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, "Finance Manager", 4);
        Manager testing2 = new Manager("Tom", "White", 928, Gender.MALE, new Department("Marketing", 321), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, "Head of Marketing", 6);

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
                System.out.println(mangerObject);
            }
        System.out.println("Number of manages =" + Manager.getNumberOfManagers());
        System.out.println();



        HumanResourceDepartment hrObject = new HumanResourceDepartment("HR", 749, "278765");
        hrObject.addPosition(true);
        hrObject.addPosition(false);
        hrObject.addPosition(true);

        int openPositions = hrObject.countOpenPositions();
        //System.out.println("HumanResource Department {" + openPositions + " positions open }");
        logger.info("HumanResource Department {" + openPositions + " positions open }");
        try {

            hrObject.setSocialSecurity("123456");
            hrObject.setSocialSecurity("876543");
            hrObject.setSocialSecurity("987654");
            //System.out.println("Social Security Number is correctly provided.");
            logger.error("Social Security Number is correctly provided.");
        } catch (SocialSecurityLengthException e) {
            //System.out.println("Error:" + e.getMessage());
            logger.error("Error" + e.getMessage());
        }


        List<String> equipmentList = new ArrayList<>();
        equipmentList.add("3D Printer");
        equipmentList.add("Power Supply");

        EngineeringDepartment engineerObject = new EngineeringDepartment("Engineering Department", 987, equipmentList);
        //System.out.println(engineerObject.toString());
         logger.info(engineerObject.toString());
        FinanceDepartment financeObject = new FinanceDepartment("Finance Department", 123, 20000);
        //System.out.println(financeObject.toString());
         logger.info(financeObject.toString());

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


        }
}
/*
    String inputFile = "src/main/resources/text.txt";
    String outputFile = "src/main/resources/uniqueWordCount.txt";

        FileReaderFolder.FileReader.countUniqueWords(inputFile, outputFile);
}*/

        //logger.error("Error ");
