package org.sda.repository;

import org.sda.domain.Course;
import org.sda.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CourseRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    @Transactional
    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            throw new UnsupportedOperationException();
        }
        return course;
    }
}
