package com.domain.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;

@Entity
@Table(name = "log")
@Setter
public class Log extends ResourceSupport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long Id;
    @Getter
    private String title;
    @Getter
    private Integer date;
    @Getter
    private Integer distance;
    @Getter
    private String fromharbor;
    @Getter
    private String toharbor;

    public Log(){
    }

    public Log(String title, Integer date, Integer distance, String fromharbor, String toharbor) {
        this.title = title;
        this.date = date;
        this.distance = distance;
        this.fromharbor = fromharbor;
        this.toharbor = toharbor;
    }
}
