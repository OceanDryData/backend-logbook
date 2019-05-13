package com.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Setter
public class User extends ResourceSupport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long Id;
    @Getter
    private String Email;
    @Getter
    private String Password;
    @Getter
    private String FirstName;
    @Getter
    private String LastName;

    public User() {
    }

    public User(String email, String password, String firstName, String lastName) {
        Email = email;
        Password = password;
        FirstName = firstName;
        LastName = lastName;

    }

}