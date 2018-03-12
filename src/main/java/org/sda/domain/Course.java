package org.sda.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    //    Pole id, GeneratedValue zapewnia nam uzycie bazodanowej sekwencji do generowania kolejnych ID
    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<User> users = new ArrayList<>();

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Review review) {
        this.reviews.add(review);
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
