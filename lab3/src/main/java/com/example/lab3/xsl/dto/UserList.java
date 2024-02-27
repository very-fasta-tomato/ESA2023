package com.example.lab3.xsl.dto;

import com.example.lab3.model.UserEntity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class UserList {
    private List<User> usersList = new ArrayList<User>();

    public UserList() {
    }

    public UserList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

    @XmlElement(name = "user")
    public List<User> getUsers() {
        return usersList;
    }

    public void setUsersList(ArrayList<User> usersList) {
        this.usersList = usersList;
    }

}
