package com.example.sallereservation.dao;

import com.example.sallereservation.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {
    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public User getUserByUsername(String username) {
        Session session = sessionFactory.openSession();
        Query<User> query = session.createQuery("from User where username = :username", User.class);
        query.setParameter("username", username);
        User user = query.uniqueResult();
        session.close();
        return user;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        session.close();
        return users;
    }

    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
