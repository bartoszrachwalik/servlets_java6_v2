package org.sda.repository;

import org.sda.domain.Course;
import org.sda.domain.Review;
import org.sda.util.TODO;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReviewRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional(readOnly = true)
    public Review findById(long id) {
        return em.find(Review.class, id);
    }

    @Transactional
    public void deleteById(long id) {
        Review reviewToDelete = findById(id);
        em.remove(reviewToDelete);
    }

    @Transactional(readOnly = true)
    @TODO
    public List<Review> findAll() {
        return (List<Review>) em.createQuery("select c from Review c").getResultList();
    }

    @Transactional
    public Review save(Review review) {
        if (review.getId() == null) {
            em.persist(review);
        } else {
            throw new UnsupportedOperationException();
        }
        return review;
    }
}
