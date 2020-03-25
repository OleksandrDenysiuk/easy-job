package com.portfolio.easyjob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "types_of_message")
public class TypeOfMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public TypeOfMessage(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
