package ru.itis.model;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@EqualsAndHashCode

public class User {
    private long id;
    private String nameOfUser;
    private String surnameOfUser;
    private String usernameOfUser;
    private Integer ageOfUser;
    private String passwordOfUser;
}
