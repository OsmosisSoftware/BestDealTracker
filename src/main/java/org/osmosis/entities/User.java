package org.osmosis.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class User {

    @Id
    private String user;
    private String password;

    @DBRef
    private List<AmazonItem> myAmazonItems;

    @DBRef
    private List<PcComponentesItem> myPcComponentesItems;

    public User(){}

    public User(
        String user,
        String password,
        List<AmazonItem> myAmazonItems,
        List<PcComponentesItem> myPcComponentesItems
    ) {
        this.setUser(user);
        this.setPassword(password);
        this.setMyAmazonItems(myAmazonItems);
        this.setMyPcComponentesItems(myPcComponentesItems);
    }

    public User(
        String user,
        String password
    ) {
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

    public void setMyAmazonItems(List<AmazonItem> myAmazonItems){
        if (myAmazonItems == null) throw new NullPointerException();

        this.myAmazonItems = myAmazonItems;
    }

    public void setMyPcComponentesItems(List<PcComponentesItem> myPcComponentesItems){
        if (myPcComponentesItems == null) throw new NullPointerException();

        this.myPcComponentesItems = myPcComponentesItems;
    }

    public List<AmazonItem> getMyAmazonItems(){
        return this.myAmazonItems;
    }

    public List<PcComponentesItem> getMyPcComponentesItems(){
        return this.myPcComponentesItems;
    }

    public void addAmazonItem(AmazonItem amazonItem){
        if (amazonItem == null || amazonItem.getAmazonItemId().equals("")) throw new IllegalArgumentException("");

        this.myAmazonItems.add(amazonItem);
    }

    public void addPcComponentesItem(PcComponentesItem pcComponentesItem){
        if (pcComponentesItem == null || pcComponentesItem.getPcComponentesItemId().equals("")) throw new IllegalArgumentException("");

        this.myPcComponentesItems.add(pcComponentesItem);
    }
}
