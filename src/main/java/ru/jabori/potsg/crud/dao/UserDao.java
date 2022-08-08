package ru.jabori.potsg.crud.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Users;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class UserDao {

    private final EntityManager entityManager;

    @Autowired
    public UserDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Transactional
    public void getSome(){
        Session session = entityManager.unwrap(Session.class);

        List<Users> people = session.createQuery("select u from Users u", Users.class).getResultList();

//        List<Object[]> t1 = session.createNativeQuery("SELECT * FROM users").list();

        System.out.println(String.valueOf(people.get(0).getName()));

//        for(Users user: people){
//            System.out.println(String.valueOf(user.getId())+ " " + user.getName());
//        }
    }

}
