package model;

import java.io.Serializable;

public class Course implements Serializable{
    private String code;
    private String name;
    private String description; 
    private int credits;

    public Course(String code, String name, String description, int credits){
        this.code = code;
        this.name = name;
        this.description = description;
        this.credits = credits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return "Course " + "code = " + code + " - " + "name = '" + name + " - " + "credits = " +  credits;
    }
}
