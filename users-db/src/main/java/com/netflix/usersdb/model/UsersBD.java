package com.netflix.usersdb.model;


import com.netflix.common.model.User;
import org.springframework.data.annotation.Id;

public class UsersBD extends User {
    @Id
    private String id;

}
