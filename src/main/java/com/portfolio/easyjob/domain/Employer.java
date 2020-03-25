package com.portfolio.easyjob.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employer{

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    private User user;

    private String nameOfOrganization;

    private String email;

    private int bankAccountNumber;

    private String phoneNumber;

    public Employer(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", nameOfOrganization='" + nameOfOrganization + '\'' +
                '}';
    }
}
