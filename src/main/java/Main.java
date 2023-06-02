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
import genericLinkedList.LicenseLinkedList;
import interfaces.ICheckName;
import interfaces.ICheckProject;
import interfaces.ICheckSSN;
import projects.Project;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;

import fileReaderFolder.FileReader;
import projects.ProjectScheduleCheck;
//import genericLinkedList.LicenseLinkedList;
//import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InvalidEmployeeId, NullDepartmentException {

        System.out.println(Thread.currentThread().getName());

        ItCompany itObject = new ItCompany("AIN Technologies", "24th street N, Alexander MD");

        UnaryOperator<String> capitalize = str -> str.toUpperCase();
        String capitalizedCompanyName = capitalize.apply(itObject.getCompanyName());
        logger.info(capitalizedCompanyName);
        Consumer<String> compAddress = address -> logger.info("Address = " + itObject.getAddress());
        compAddress.accept(itObject.getAddress());

        List<Department> departmentList = new ArrayList<>();
        Department department1 = new Department("Sales Department", 987);
        Department department2 = new Department("Marketing Department", 986);
        departmentList.add(department1);
        departmentList.add(department2);

        departmentList.stream().forEach(departmentObject -> {
            try {
                departmentObject.controlDepartment();
            } catch (NullDepartmentException e) {
                logger.error("Error: " + e.getMessage());
            }
        });

        departmentList.stream().forEach(department -> logger.info(department));

        System.out.println();

                List<BackendDeveloper> backendDeveloperList = Arrays.asList(
                        new BackendDeveloper("Amy", "Lee", 43, 987, Gender.FEMALE,
                                new Department("Backend Developer", 665), ContractType.FULL_TIME, ExperienceLevel.ADVANCED,
                                new Project("Web development", LocalDate.of(2023, 2, 11), LocalDate.of(2023, 3, 29)), ProgramingLanguages.JAVA, 5000),
                        new BackendDeveloper("Mia", "Joy", 30, 867, Gender.FEMALE,
                                new Department("Backend Developer", 665), ContractType.INTERNSHIP, ExperienceLevel.ENTRY,
                                new Project("API Development", LocalDate.of(2023, 01, 07), LocalDate.of(2023, 03, 12)), ProgramingLanguages.JAVA, 4500));

              backendDeveloperList.stream().forEach(backendDeveloper -> {
                  try{
                      logger.info(backendDeveloper.toString());
                  }
                      catch (ProjectException e) {
                          logger.error("Error" + e.getMessage());
                      }
              });
            System.out.println();

        List<FrontendDeveloper> frontendDeveloperList = Arrays.asList(
                new FrontendDeveloper("Adam", "Cole", 44, 543, Gender.OTHER,
                        new Department("Frontend Developer", 442), ContractType.FULL_TIME, ExperienceLevel.INTERMEDIATE, "Angular",
                        new Project("Web Design 1", LocalDate.of(2023, 01, 10), LocalDate.of(2023, 04, 15)), 4000),
                new FrontendDeveloper("Emma", "Oliver", 29, 987, Gender.FEMALE,
                        new Department("Frontend Developer", 442), ContractType.FULL_TIME, ExperienceLevel.INTERMEDIATE, "Vue.js",
                        new Project("Web Design 2", LocalDate.of(2023, 04, 30), LocalDate.of(2023, 06, 05)), 4500)
        );
        frontendDeveloperList.stream().forEach(frontendDeveloper -> {
            try {
                logger.info(frontendDeveloper.toString());
            } catch (ProjectException e) {
                logger.error("Error: " + e.getMessage());
            }
        });

            System.out.println();

                List<QualityAssurance> qualityAssuranceList = Arrays.asList(
                        new QualityAssurance("Jack", "Oliver", 35, 654, Gender.MALE,
                                new Department("Quality Assurance", 224), ContractType.CONTRACTOR, ExperienceLevel.ADVANCED, false,
                                new Project("Usability Testing", LocalDate.of(2023, 02, 06), LocalDate.of(2023, 03, 19)), 5000),
                        new QualityAssurance("Daniel", "William", 28, 385, Gender.OTHER,
                                new Department("Quality Assurance", 224), ContractType.FULL_TIME, ExperienceLevel.INTERMEDIATE, true,
                                new Project("Mobile Testing ", LocalDate.of(2023, 04, 01), LocalDate.of(2023, 05, 30)), 4500)
                );
                qualityAssuranceList.stream().forEach(qualityAssurance -> {
                    try{logger.info(qualityAssurance.toString());
                    } catch (ProjectException e) {
                        logger.error("Error" + e.getMessage());
                    }
                });
                System.out.println();



            LicenseLinkedList <Manager> managerList = new LicenseLinkedList();
            Manager manager1 = new Manager("Sam", "Jon", 55, 980, Gender.MALE, new Department("Finance Department", 546), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, "Finance Manager", 7, 10000);
            Manager manager2 = new Manager("Tom", "White", 41, 928, Gender.MALE, new Department("Marketing Department", 321), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, "Head of Marketing", 6, 7000);

            managerList.add(manager1);
            managerList.add(manager2);
            managerList.stream().forEach(manager -> {
                try {
                    manager.controlManger();
                } catch (InvalidYearsOfExperience e) {
                    logger.error("Error" + e.getMessage());
                }
            });
           managerList.stream().forEach(manager -> logger.info(manager));

            logger.info("Number of manages =" + Manager.getNumberOfManagers());
            System.out.println();


        LicenseLinkedList <Employee> employeeList = new LicenseLinkedList<>();
        Employee employee1 = new Employee("Sam", "Smith", 44, 987, Gender.MALE, new Department("Marketing Department", 768), ContractType.FULL_TIME, ExperienceLevel.ADVANCED, 4000);
        Employee employee2 = new Employee("Mary", "Williams", 35, 879, Gender.FEMALE, new Department("sales Department", 543), ContractType.CONTRACTOR, ExperienceLevel.INTERMEDIATE, 5000);
        Employee employee3 = new Employee("Sara","Tom",44,987,Gender.FEMALE,new Department("Sales Department",543),ContractType.FULL_TIME,ExperienceLevel.ADVANCED, 5000);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);

        employeeList.stream().forEach(employee -> {
            try {
                employee.controlEmployee();
            } catch (InvalidEmployeeId e) {
                logger.error("Error" + e.getMessage());
            }
        });
        employeeList.stream().forEach(employee -> logger.info(employee));

            logger.info("Number of employees = " + Employee.getNumberOfEmployee());
            System.out.println();

            ICheckName<String> onlyLetters = name -> name.matches("[a-zA-Z]+");
            for (Employee employee : employeeList) {
                logger.info("First and last name are all letters: " + onlyLetters.validName(employee.getFirstName()) + " " + onlyLetters.validName(employee.getLastName()));
            }
            System.out.println();

            Stream<Employee> employeeStream = employeeList.stream().filter(employee -> employee.getEmployeeId() == 987);
            employeeStream.forEach(Employee -> logger.info(Employee.getFirstName() + " " + Employee.getLastName()));
        // print  female
            List<Employee> females = employeeList.stream()
                    .filter(employee -> employee.getGender().equals(Gender.FEMALE))
                    .collect(Collectors.toList());
        females.forEach(employee -> logger.info(employee.toString()));

          //age of employees
            boolean allMatch = employeeList.stream().allMatch(employee -> employee.getAge() < 65 && employee.getAge() > 20);
            logger.info("All employees are between 20 to 65 age:" + allMatch);
            //to print employees by gender

        Map<Gender, List<Employee>> groupByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender));

        groupByGender.forEach((gender, employees) -> {
            logger.info(gender.toString());
            employees.forEach(employee -> logger.info(employee.toString()));
        });
          //max salary of employees

            Optional<String> highestPaidEmployeeName = employeeList.stream()
                    .max(Comparator.comparingDouble(Employee::getSalary))
                    .map(Employee::getFirstName);
            highestPaidEmployeeName.ifPresent(name -> logger.info("Highest paid employee: " + name));


            HumanResourceDepartment hrObject = new HumanResourceDepartment("HR", 749, "278765");
            hrObject.addPosition(true);
            hrObject.addPosition(false);
            hrObject.addPosition(true);

            int openPositions = hrObject.countOpenPositions();
            logger.info("HumanResource Department {" + openPositions + " positions open }");


         List<String>socialSecurityNumber = Arrays.asList("879739","838901");
         socialSecurityNumber.stream().forEach(snn-> {
             try {
                 hrObject.setSocialSecurity(snn);
                 logger.warn("Social Security Number is correctly provided.");
             } catch (SocialSecurityLengthException e) {
                 logger.error("Error: " + e.getMessage());
             }
         });

            ICheckSSN ssnString = ssn -> !ssn.matches("\\d+");
            logger.info("ssn is numeric value " + ssnString.validateSSN(hrObject.getSocialSecurity()));


            List<String> equipmentList = new ArrayList<>();
            equipmentList.add("3D Printer");
            equipmentList.add("Power Supply");

            EngineeringDepartment engineerObject = new EngineeringDepartment("Engineering Department", 987, equipmentList);
            logger.info(engineerObject.toString());
            FinanceDepartment financeObject = new FinanceDepartment("Finance Department", 123, 20000);
            logger.info(financeObject.toString());
            int budgetOfYear = 1000000;
            Predicate<FinanceDepartment> budgetForYear = finance -> finance.getBudget() <= budgetOfYear;
            boolean isBudgetHigher = budgetForYear.test(financeObject);


            LicenseLinkedList<Client> clientList = new LicenseLinkedList<>();
               Client client1 = new Client("John Jakes", "303-913-0554");
               Client client2 = new Client("Ben Adam","303-456-7894");
                clientList.add(client1);
                clientList.add(client2);
                clientList.stream().forEach(Client->{
                    logger.info(Client.toString());
                });



        System.out.println();


            System.out.println();
            logger.info("AIN Technologies Department List ");
            for (DepartmentList depListObject : DepartmentList.values()) {
                logger.info(depListObject.getDepartments());
            }
            FileReader fileRer = new FileReader();
            fileRer.countUniqueWords("src/main/resources/uniqueWordCount.txt");

        }

    }
