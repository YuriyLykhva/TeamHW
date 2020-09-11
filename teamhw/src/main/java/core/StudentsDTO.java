package core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentsDTO {

    private String lastName;
    private int grade;
    private int age;

    public StudentsDTO(@JsonProperty("last_name") String lastName,
                       @JsonProperty("grade") int grade,
                       @JsonProperty("age") int age) {
        this.lastName = lastName;
        this.grade = grade;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public StudentsDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getGrade() {
        return grade;
    }

    public StudentsDTO setGrade(int grade) {
        this.grade = grade;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentsDTO setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Students {" +
                "lastName='" + lastName + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }
}
