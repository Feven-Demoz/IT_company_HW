package enums;

public enum ExperienceLevel {
    ENTRY ("Entry", 1),
    INTERMEDIATE ("Intermediate", 3),
    ADVANCED("Advanced",7);
    private String level;
    private int yearsOfExperience;

    ExperienceLevel(String levelEnter, int yearsOfExperienceEnter) {
        this.level = levelEnter;
        this.yearsOfExperience = yearsOfExperienceEnter;
    }

    public String getLevel() {
        return level;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
