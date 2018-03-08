package org.sda.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Length(max = 20)
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstName;

    @NotBlank
    @Length(max = 30)
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastName;

    @NotBlank
    @Length(max = 30)
    @Email
    @Column(name = "email", nullable = false, length = 30, unique = true)
    private String email;

    @ManyToMany
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
