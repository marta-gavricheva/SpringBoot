package com.example.springBootdemo2.dao;

import com.example.springBootdemo2.model.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;




@Component
@Transactional
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    //select * fom user
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    //create- insert table
    @Override
    public void addUser(User user) {
        entityManager.persist(user);

    }

    //updade user
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }

    //delete user
    @Override
    public User removeUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        return user;
    }

    @Override
    public User getUserId(long id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id =:user_id", User.class);
        query.setParameter("user_id", id);
        return query.getResultList().stream().findAny().orElse(null);

    }
}
