package com.portfolio.easyjob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private TypeOfMessage type;

    private String content;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(
            fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_id")
    private User recipient;

}
