package com.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity
@Getter
@Setter
public class Log extends ResourceSupport {
    public Link getId() {
        return new Link(id.toString());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date date;
    private String distance;
    private String marina;
    private String destination;

    protected Log() {
    }

    public Log(String title, Date date, String distance, String marina, String destination) {
        this.title = title;
        this.date = date;
        this.distance = distance;
        this.marina = marina;
        this.destination = destination;
    }


}

