package ru.jabori.potsg.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import ru.jabori.potsg.crud.dao.TransactionService;
import ru.jabori.potsg.crud.filter.JwtUtil;
import ru.jabori.potsg.crud.models.PostgreSqlModels.Chats;
import ru.jabori.potsg.crud.models.RestApiModels.Initialization.Authentication.AuthenticationRequest;
import ru.jabori.potsg.crud.models.RestApiModels.Initialization.Authentication.AuthenticationResponse;
import ru.jabori.potsg.crud.models.RestApiModels.Initialization.Authentication.GetNewTokenRequest;
import ru.jabori.potsg.crud.models.RestApiModels.Initialization.Registration.RegistrationRequest;
import ru.jabori.potsg.crud.models.RestApiModels.Initialization.Registration.RegistrationResponse;
import ru.jabori.potsg.crud.service.AppUserDetailService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DeafaultController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TransactionService userDao;

    @Autowired
    private AppUserDetailService appUserDetailService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String firstPage() {

        return "Hello";

    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = appUserDetailService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);
        final String jwtRestart = jwtUtil.generateRestartToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt,jwtRestart));
    }

    @PostMapping(value = "/token")
    public ResponseEntity<?> updateToken(@RequestBody GetNewTokenRequest getNewTokenRequest) throws Exception {
        final String token = getNewTokenRequest.getJwt();
        final String username = jwtUtil.extractUsername(token);

        if(username!= null &&  jwtUtil.isJwtUpdateToken(token)){
            UserDetails userDetails = appUserDetailService
                    .loadUserByUsername(username);

            final String jwt = jwtUtil.generateToken(userDetails);
            final String jwtUpdate = jwtUtil.generateRestartToken(userDetails);

            return ResponseEntity.ok(new AuthenticationResponse(jwt,jwtUpdate));
        }else throw new Exception("Wrong jwt");
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerNewUser(@RequestBody RegistrationRequest regRequest)throws Exception{
        System.out.println(regRequest.getLogin() + "------------"+ regRequest.getPassword());
        appUserDetailService.registerUser(regRequest.getLogin(),regRequest.getPassword(),
                regRequest.getUserName(),regRequest.getEmail(),regRequest.getUserNumber(),
                regRequest.getInformation(),regRequest.getRegion());
        return ResponseEntity.ok(new RegistrationResponse("Ok","The user has been registered"));
    }

}
