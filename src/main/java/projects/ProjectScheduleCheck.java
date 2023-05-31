package projects;

import interfaces.ICheckProject;

import java.time.LocalDate;

public class ProjectScheduleCheck implements ICheckProject {

    @Override
    public boolean test(Project project) {
        ICheckProject test = project1 ->
            project1.getStartDate().isBefore(LocalDate.now()) && project1.getFinishDate().isAfter(LocalDate.now());
        return test.test(project);
    }
}
