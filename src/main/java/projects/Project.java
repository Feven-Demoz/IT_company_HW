package projects;

import exception.ProjectException;

public class Project {
    private String projectName;
    private int startDate;
    private int finishDate;

    public Project(String projectNameEnter, int startDateEnter, int finishDateEnter) {
        if (startDateEnter>finishDateEnter){
            throw new ProjectException("Start date can not be after finish date.");
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

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(int finishDate) {
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
