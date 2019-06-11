package com.domain.models;

import lombok.Getter;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
@Table(name = "harbor")
public class Harbor extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Getter
    private String name;
    @Getter
    private String harbor;
    @Getter
    private Integer spaces;
    @Getter
    private Integer occupied;

    public Harbor() {
    }


    public Harbor(String name, String harbor, Integer spaces, Integer occupied) {
        this.name = name;
        this.harbor = harbor;
        this.spaces = spaces;
        this.occupied = occupied;
    }

}
