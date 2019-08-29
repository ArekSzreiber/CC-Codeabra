package com.codeabra.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Table(name = "students", schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(name = "name")
    @NotNull(message = "Name can not be empty")
    @Size(min = 2, max = 15)
    public String name;

    @Column(name = "surname")
    @NotNull
    @Size(min = 2, max = 30)
    public String surname;

    @Column(name = "email_address")
    public String emailAddress;

    @Column(name = "phone_number")
    public String phoneNumber;//add regex //@Pattern(regexp = "^(\\+\\d\\d)? ?\\d{9}$")

    //Actually, we don’t have to specify the @Enumerated annotation at all if we are going to persist the Gender by the enum‘s ordinal.
//    @Enumerated(EnumType.ORDINAL)
//    public Gender gender;

}
