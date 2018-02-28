package org.sda.dto;

public class Student {

    private String name;

    private String email;

    private boolean present;

    public Student(String name, String email, boolean present) {
        this.name = name;
        this.email = email;
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}
