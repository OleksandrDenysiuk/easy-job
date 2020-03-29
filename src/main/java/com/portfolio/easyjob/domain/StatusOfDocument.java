package com.portfolio.easyjob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "status_of_document")
public class StatusOfDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public StatusOfDocument(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
