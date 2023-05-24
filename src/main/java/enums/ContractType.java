package enums;

public enum ContractType {
    FULL_TIME("Full Time", 40),
    PART_TIME("Part Time", 20),
    CONTRACTOR("Contractor",40),
    INTERNSHIP("Internship", 20);
    private final String contractType;
    private final int hoursPerWeek;

    ContractType(String contractType, int hoursPerWeek) {
        this.contractType = contractType;
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getContractType() {
        return contractType;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }
}
