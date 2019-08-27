package com.codeabra.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Table(name = "students", schema = "public")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull(message = "Name can not be empty")
    @Column(name = "name")
    public String name;

    @Column(name = "surname")
    public String surname;

    @Column(name = "email_address")
    public String emailAddress;

    @Column(name = "phone_number")
    public String phoneNumber;//TODO add regex //@Pattern(regexp = "^(\\+\\d\\d)? ?\\d{9}$")

    //Actually, we don’t have to specify the @Enumerated annotation at all if we are going to persist the Gender by the enum‘s ordinal.
    @Enumerated(EnumType.ORDINAL)
    public Gender gender;

    public Student() {
    }
}
