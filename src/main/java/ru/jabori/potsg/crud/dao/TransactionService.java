package ru.jabori.potsg.crud.dao;

import org.apache.catalina.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.jabori.potsg.crud.models.PostgreSqlModels.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TransactionService {

    private final EntityManager entityManager;

    @Autowired
    public TransactionService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //аннотация позволяет выполнять откат для всех exception, так по дефолту rollback производится
    // только для runtime exceptions
    @Transactional(rollbackOn = Exception.class)
    public void addUser(String name, String login,String password,String email,
                        String number,String information, String region) {

        Session session = entityManager.unwrap(Session.class);
        Users newUser = new Users(name,login,DigestUtils.sha256Hex(password),email,region,information,number);

        session.save(newUser);

    }

    @Transactional
    public Chats createNewChat(String name, String description,String currency,int creatorId){
        Session session = entityManager.unwrap(Session.class);

        Chats chat = new Chats(name,description,currency);

        session.save(chat);

        Links link = new Links(new LinksPK(chat.getId(),creatorId),true,true,1);
        session.save(link);
        return chat;
    }

    @Transactional(rollbackOn = Exception.class)
    public void addLink(){
        Session session = entityManager.unwrap(Session.class);
        Links link = new Links(new LinksPK(9,8),true,true,2);

        session.save(link);
    }

    @Transactional(rollbackOn = Exception.class)
    public void addUserToChat(int authorId, int invitedId, int chat_id,
                              boolean haveInvitedReductionRight,
                              int invitedTeamId) throws Exception{
        Session session = entityManager.unwrap(Session.class);

        Users author = session.find(Users.class,authorId);
        Users invitedUser = session.find(Users.class,invitedId);

        Query chatQuery = session.createQuery("select c from Chats c LEFT JOIN FETCH c.links WHERE c.id= " + String.valueOf(chat_id));

        Optional<Chats> chat = chatQuery.getResultList().stream().findFirst();

        if(author == null) throw new Exception("User with id " + String.valueOf(authorId)+
                " doesn't exist");
        if(invitedUser == null) throw new Exception("User with id " + String.valueOf(invitedId)+
                " doesn't exist");
        if(!chat.isPresent()) throw new Exception("Chat with this id " +  chat_id + " doesn't exist");

        Optional<Links> authorLink = chat.stream().findFirst().get().getLinks().stream().
                filter(x->x.getPrimaryKey().getUserId()==authorId).findAny();

        if (!authorLink.isPresent() ) throw new Exception("User " + author.getName() +
                " doesn't have access to chat " + chat.stream().findFirst().get().getName());

        if(authorLink.get().isAdmin()==false)
            throw new Exception(authorLink.get().getLinkUser().getName()+ " isn't an admin for chat " + authorLink.get().getChat().getName());

        if(authorLink.get().getTeamId() == invitedTeamId){
            session.save(new Links(new LinksPK(chat_id,invitedId),false,haveInvitedReductionRight,invitedTeamId));
        } else {


            if(chat.get().getLinks().stream().filter(x->x.getTeamId()==invitedTeamId).findAny().isPresent())
                throw new Exception("User " + author.getName()+ " can't add other user as partner");

            System.out.println(String.valueOf(chat_id)+"====="+invitedId);
            session.save(new Links(new LinksPK(chat_id,invitedId),true,true,invitedTeamId));
        }

    }

    @Transactional(rollbackOn = Exception.class)
    public void addMessageToChat(int author_id,float operation, String description, int chat_id)
                                throws Exception {
        Session session = entityManager.unwrap(Session.class);

        if (session.createQuery("select l from Links l where l.primaryKey.userId=" + author_id +
                " AND l.primaryKey.chatId=" + chat_id).getResultList().isEmpty())

            throw new Exception("User " + session.find(Users.class,author_id).getName()+
                    " doesn't have access to chat " + session.find(Chats.class,chat_id).getName());


        Messages msg = new Messages(new MessagesPK(author_id),operation,description,chat_id);
        session.save(msg);

        System.out.println(msg.toString());
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Chats> getChats(int userId){
        Session session = entityManager.unwrap(Session.class);

        Query chatsQuery = session.createQuery("select c from Links l left join Chats c on l.chat.id=c.id " +
                "join fetch c.messages where l.linkUser.id=:userId");
        chatsQuery.setParameter("userId",userId);
        // Получили перечень чатов пользователя userId, из этих чатов будем вытаскивать количество сообщений
        List<Chats> chats = chatsQuery.getResultList();

        return chats.stream().distinct().collect(Collectors.toList());
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Transactions> getLastTransactionListOfUserChats(int userId){
        Session session = entityManager.unwrap(Session.class);

        Query trQuery = session.createSQLQuery("select tr2.* from (select t.chat_id, MAX(t.acception_date_time) as max_date from transactions t  where t.chat_id IN\n" +
                "(select chat_id from links where user_id=:userId) group by t.chat_id) tr1 left join transactions tr2 \n" +
                "on tr1.chat_id=tr2.chat_id and tr1.max_date=tr2.acception_date_time").addEntity(Transactions.class);
        trQuery.setParameter("userId",userId);
        List<Transactions> transactions = trQuery.getResultList();

        return transactions;
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Links> getUserListOfChat(int chat_id){
        Session session = entityManager.unwrap(Session.class);
        // Пёолучаем список связей для конкретной таблицы
        List<Links> links = session.createQuery("select l from Links l where l.chat.id=:chat_id")
                .setParameter("chat_id",chat_id).getResultList();

        return links;
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Transactions> getTransactionsOfChat(int chat_id){
        Session session = entityManager.unwrap(Session.class);

        return session.createQuery("select t from Transactions t where t.chat.id=:chat_id order by t.transactionPK.acceptionDateTime asc")
                .setParameter("chat_id",chat_id).getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Messages> getChatMessages(int chat_id){
        Session session = entityManager.unwrap(Session.class);

        List<Messages>  messages = session.createQuery("select m from Messages m left join fetch m.chat left join fetch m.messageUser" +
                        " where m.chatId=:chat_id order by m.id.suggestionDateTime asc ")
                .setParameter("chat_id",chat_id).getResultList();
        System.out.println(messages.get(0).getMessagePK().getSuggestionDateTime());
        System.out.println(messages.get(1).getMessagePK().getSuggestionDateTime());
        return messages;
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Users> getListOfUsersByName(String name){
        Session session = entityManager.unwrap(Session.class);

        Query usersQuery = session.createQuery("select u from Users u where u.name like :name or u.login like :name");
        usersQuery.setParameter("name","%"+name+"%");



         return usersQuery.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public List<Users> getUsersByLogin(String login){
        Session session = entityManager.unwrap(Session.class);

        Query usersQuery = session.createQuery("select u from Users u where u.login=:login");
        usersQuery.setParameter("login",login);



        return usersQuery.getResultList();
    }

    @Transactional(rollbackOn = Exception.class)
    public void changeMessageStatus(int accepterId, boolean isAccepted, int chatId, int suggesterId, String dateTimeStringForm)
    throws Exception{
        Date suggestionDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                .parse(dateTimeStringForm);

        Session session = entityManager.unwrap(Session.class);
        String chatName="";
        Messages message = session.find(Messages.class,new MessagesPK(suggesterId,suggestionDateTime));
        if( message == null) throw new Exception("Message from user "+ session.find(Users.class,suggesterId).getName()+
                                                 " with date " + suggestionDateTime.toString()+ " doesn't exist");
        chatName=message.getChat().getName();

        // олучение свойств чата со всеми связями
        Query chatQuery = session.createQuery("select c from Chats c left join fetch c.links where c.id=:chatId");
        chatQuery.setParameter("chatId",chatId);
        Optional<Chats> chat = chatQuery.getResultList().stream().findFirst();
        if(chat.isEmpty()) throw new Exception("Chat with id " + chatId + " doesn't exist");
        System.out.println("3");
        //получение последней транзакции чата
        Query lastTransactionQuery= session.createQuery("select tr from Transactions tr where tr.chatId=:chatId and " +
                "tr.transactionPK.acceptionDateTime=(select MAX(transactionPK.acceptionDateTime) from Transactions where chatId=:chatId)");
        lastTransactionQuery.setParameter("chatId",chatId);

        Optional<Transactions> lastTransaction= lastTransactionQuery.getResultList().stream().findFirst();

        // получение связей каждого пользователя
        Optional<Links> accepterLink = chat.get().getLinks().stream().filter((o)->o.getPrimaryKey().getUserId()==accepterId).findAny();
        Optional<Links> suggesterLink = chat.get().getLinks().stream().filter((o)->o.getPrimaryKey().getUserId()==suggesterId).findAny();

        if(accepterLink.isEmpty()) throw new Exception("User " + session.find(User.class,accepterId)+
                " doesnt have access to chat " + chatName);

        if(suggesterLink.isEmpty()) throw new Exception("User " + session.find(User.class,suggesterId)+
                " doesnt have access to chat " + chatName);


        // проверка на наличие прав редактирования у пользователя accepter
        if(!accepterLink.get().hasReductRight() ) throw new Exception("User "+ session.find(Users.class,accepterId).getName() +
                " doesn't have redact right here");

        if(accepterLink.get().getTeamId()==suggesterLink.get().getTeamId()) {
            if (isAccepted == true) throw new Exception("User can't accept a collegue's transaction");
            else {
                if (accepterLink.get().isAdmin() == true || suggesterId == accepterId) session.remove(message);
                else throw new Exception("Only admin and author of transaction can remove one");
            }
        }else {
            if(accepterLink.get().hasReductRight()==true){
                session.remove(message);
                float lastResult = lastTransaction.isPresent()? lastTransaction.get().getResult(): 0;
                if(isAccepted==true){

                    session.save(new Transactions(new TransactionsPK(accepterId),message.getOperation(),lastResult + message.getOperation(),
                            message.getDescription(),message.getMessagePK().getSuggestionDateTime(),message.getMessagePK().getSuggesterId(),
                            chatId,false));
                }else{
                    session.save(new Transactions(new TransactionsPK(accepterId),message.getOperation(),lastResult,
                            message.getDescription(),message.getMessagePK().getSuggestionDateTime(),message.getMessagePK().getSuggesterId(),
                            chatId,true));
                }
            }
        }


    }

    @Transactional(rollbackOn = Exception.class)
    public void removeUserFromChat(int authorId, int chatId, int removedUserId,int newAdminId) throws Exception{
        Session session = entityManager.unwrap(Session.class);

        Optional<Chats> chat = session.createQuery("select c from Chats c left join fetch c.links where c.id=" + chatId)
                                                                                        .getResultList().stream().findFirst();
        if(chat.isEmpty()) throw new Exception("Chat with id "+ chatId + " doesn't exist");

        Optional<Links> authorLink = chat.get().getLinks().stream().filter((o)->o.getPrimaryKey().getUserId()==authorId).findFirst();
        if(authorId==removedUserId) {
            if(authorLink.get().isAdmin()){
                if(chat.get().getLinks().stream()
                        .filter((o)->o.getPrimaryKey().getUserId()==newAdminId).findAny().isPresent()) {
                    session.remove(authorLink);
                    session.find(Links.class,new LinksPK(chatId,newAdminId)).setAdmin(true);
                }else {
                    throw new Exception("User with id " + newAdminId + " doesn't have access for chat "+
                            chat.get().getName()+" or doesn't exist");
                }
            }else {
                session.remove(authorLink.get().getLinkUser());
            }
        }else {
            Optional<Links> removedLink = chat.get().getLinks().stream().filter((o)->o.getPrimaryKey().getUserId()==removedUserId).findFirst();
            if(authorLink.get().isAdmin() &&
                    authorLink.get().getTeamId()==removedLink.get().getTeamId()){
                session.remove(removedLink.get().getLinkUser());
            }else throw new Exception("User isn't admin or users have different team id");
        }

    }
}
