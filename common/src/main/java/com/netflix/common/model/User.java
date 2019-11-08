package com.netflix.common.model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    String name;
    String email;
    String address;
    String password;
    boolean newsletter;
    String sex;
    String country;

}
