package enums;

public enum Gender {
    FEMALE("Female"),
    MALE("Male"),
    OTHER("Other");
    private String gender;

    Gender(String genderEnter) {
        this.gender = genderEnter;
    }

    public String getGender() {
        return gender;
    }
   /* public static Gender fromString (String gender){
        for (Gender genderEnum: Gender.values()){
    if (genderEnum.getGender().equalsIgnoreCase(gender)){
        return genderEnum;
    }
        }
        throw new IllegalArgumentException("Invalid gender: " + gender);
    }*/
}
