package com.netflix.usersdb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@ToString
public class Users {
    @Id
    private String id;
    String name;
    String email;
    String address;
    String password;
    boolean newsletter;
    String sex;
    String country;

}
