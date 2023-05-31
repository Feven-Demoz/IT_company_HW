package projects;
import java.time.LocalDate;
import developer.QualityAssurance;
import exception.ProjectException;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Locale;

public class Project {
    public static Logger logger = Logger.getLogger(Project.class);
    private String projectName;
    private LocalDate  startDate;
    private LocalDate  finishDate;

    public Project(String projectNameEnter, LocalDate  startDateEnter, LocalDate  finishDateEnter) {
//        if (startDateEnter>finishDateEnter){
//            throw new ProjectException("Start date can not be after finish date.");
        if (startDateEnter.isAfter(finishDateEnter)) {
            throw new ProjectException("Start date cannot be after finish date.");
    }
        this.projectName = projectNameEnter;
        this.startDate = startDateEnter;
        this.finishDate = finishDateEnter;
    }



    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                '}';
    }
}
