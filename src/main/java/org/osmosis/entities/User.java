package org.osmosis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private String user;
    private String password;

    public User(){}

    public User(String user, String password){
        this.setUser(user);
        this.setPassword(password);
    }

    public void setUser(String user){
        if(user == null || user.equals("")) throw new IllegalArgumentException("Name is null");

        this.user = user;
    }

    public void setPassword(String password){
        if(password == null || password.length() < 6) throw new IllegalArgumentException("Invalid password");

        this.password = password;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
}
