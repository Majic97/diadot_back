package ru.jabori.potsg.crud.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Chats;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Links;
import ru.jabori.potsg.crud.models.PostgreSqlModels.LinksPK;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Users;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
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

        List<Chats> people = session.createQuery("select c from Chats c", Chats.class).getResultList();



    }

    @Transactional
    public void createNewChat(){
        Session session = entityManager.unwrap(Session.class);

        Chats insert_chat = new Chats("Default chat","","usd");

        session.save(insert_chat);

        Date currentDateTime = new Date();

        Links link = new Links(new LinksPK(insert_chat.getId(),1),true,
                true, 1);
        session.save(link);


    }

}
