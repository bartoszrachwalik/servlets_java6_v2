package org.sda.repository;

import org.sda.domain.Course;
import org.sda.util.TODO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    @Transactional
    public void deleteById(long id) {
        Course courseToDelete = findById(id);
        em.remove(courseToDelete);
    }

    @Transactional(readOnly = true)
    @TODO
    public List<Course> findAll() {
        return (List<Course>) em.createQuery("select c from Course c").getResultList();
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
