package com.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;

@Entity
@Table(name = "Log")
@Setter
public class Log extends ResourceSupport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long Id;
    @Getter
    private String Title;
    @Getter
    private DateFormat Date;
    @Getter
    private Double Distance;
    @Getter
    private String Marina;
    @Getter
    private String Destination;

    public Log(){
    }

    public Log(String title, DateFormat date, Double distance, String marina, String destination) {
        Title = title;
        Date = date;
        Distance = distance;
        Marina = marina;
        Destination = destination;
    }
}
