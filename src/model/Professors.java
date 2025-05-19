package model;

import java.io.Serializable;;

public class Professors implements Serializable{
    private String id;
    private String idType;
    private String fullName;
    private String email;

    public Professors (String id, String idType, String fullname, String email){
        this.id = id;
        this.idType = idType;
        this.fullName = fullname;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Professor " + "id = " + id + " - " + "Fullname = " + fullName + " - " + "email = " + email;
    }
}
