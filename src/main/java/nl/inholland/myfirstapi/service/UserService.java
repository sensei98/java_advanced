package nl.inholland.myfirstapi.service;

import lombok.extern.java.Log;
import nl.inholland.myfirstapi.Repository.UserRepository;
import nl.inholland.myfirstapi.model.Role;
import nl.inholland.myfirstapi.model.User;
import nl.inholland.myfirstapi.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Log
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    public String add(String username, String password, List<Role> roles){
        if(userRepository.findUserByUsername(username) == null){
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder().encode(password));
            if(roles.size() == 0){
                user.setRoles(List.of(Role.ROLE_USER,Role.ROLE_ADMIN));
            }
            else{
                user.setRoles(roles);
            }
            log.info(user.toString());
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(),user.getRoles());
        }
            throw  new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Username is already in use");

    }
    public String login(String username, String password){
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            return jwtTokenProvider.createToken(username,userRepository.findUserByUsername(username).getRoles());
        }
        catch(AuthenticationException ae){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY,"Invalid credentials");
        }
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }

}
