package character;

import enums.Gender;

public abstract class Person{
    protected String firstName;
    protected String lastName;
    protected Gender gender;


    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }
/*
    public Person(String firstNameEnter, String lastNameEnter) {
        this.firstName = firstNameEnter;
        this.lastName = lastNameEnter;
    }*/

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public final Gender getGender() {
        return gender;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public abstract void profileCheck();
}
