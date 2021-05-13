package nl.inholland.myfirstapi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity //saves to the database
@Data //getters,setters,tostring
public class User {

    @Id
    @GeneratedValue //sequence starting with 1
    private long id;
    private String username;
    private String password;

    @ElementCollection(fetch= FetchType.EAGER) //getting data all at once
    List<Role> roles;
}
