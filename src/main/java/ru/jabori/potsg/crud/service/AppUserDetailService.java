package ru.jabori.potsg.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.jabori.potsg.crud.dao.TransactionService;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private TransactionService transactionService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        List<Users> userList = transactionService.getUsersByLogin(login);
        if(userList.isEmpty()) throw new UsernameNotFoundException("Wrong username");
        Users user = userList.stream().findFirst().get();
        return new User(user.getLogin(),user.getPassword(), new ArrayList<>());

    }

    public String registerUser (String login, String password,
                                String name, String email, String number,
                                String inf, String region) throws IOException{
        List<Users> users = transactionService.getUsersByLogin(login);
        if (!users.isEmpty()) throw new IOException("User with this login already exist");

        transactionService.addUser(name,login,password,email,number,inf,region);

        return "Success";
    }
}
