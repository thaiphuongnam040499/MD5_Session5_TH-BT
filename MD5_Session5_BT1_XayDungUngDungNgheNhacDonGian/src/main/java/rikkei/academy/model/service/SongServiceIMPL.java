package rikkei.academy.model.service;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import rikkei.academy.model.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

public class SongServiceIMPL implements ISongService {
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
    public List<Song> findAll() {
        String querystr= "select s from Song as s";
        TypedQuery<Song> query =entityManager.createQuery(querystr,Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void save(Song song) {

    }
}
