package rikkei.academy.model.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import rikkei.academy.model.entity.Feedback;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FeedbackServiceIMPL implements IFeedbackService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Feedback> findAll() {
        String querystr1 = "SELECT f FROM Feedback as f where date = current_date()";
        TypedQuery<Feedback> query = entityManager.createQuery(querystr1, Feedback.class);
        return query.getResultList();
    }

    @Override
    public Feedback findById(Long id) {
        String querystr = "SELECT f FROM Feedback as f where f.id = :id";
        TypedQuery<Feedback> query = entityManager.createQuery(querystr, Feedback.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void save(Feedback feedback) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            if (feedback.getId() != null) {
                Feedback feedback1 = findById(feedback.getId());
                feedback1.setPoint(feedback.getPoint());
                feedback1.setAuthor(feedback.getAuthor());
                feedback1.setMessage(feedback.getMessage());
                feedback1.setDate(feedback.getDate());
            }
            session.saveOrUpdate(feedback);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
