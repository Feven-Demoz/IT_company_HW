package character;

import enums.Gender;

public abstract class Person{
    protected String firstName;
    protected String lastName;
    protected Gender gender;
protected int age;

    public Person(String firstName, String lastName,int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

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

    public int getAge() {return age;}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public abstract void profileCheck();
}
