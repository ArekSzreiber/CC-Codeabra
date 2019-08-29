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
    public Long studentId;

    @Column(name = "name")
    @NotNull(message = "Cannot be empty")
    @Size(min = 2, message = "Minimum length is 2")
    @Size(max = 15, message = "Maximum length is 15")
    public String name;

    @Column(name = "surname")
    @NotNull(message = "Cannot be empty")
    @Size(min = 2, message = "Minimum length is 2")
    @Size(max = 30, message = "Maximum length is 30")
    public String surname;

    @Column(name = "email_address")
    public String emailAddress;

    @Column(name = "phone_number")
    public String phoneNumber;//add regex //@Pattern(regexp = "^(\\+\\d\\d)? ?\\d{9}$")

    //Actually, we don’t have to specify the @Enumerated annotation at all if we are going to persist the Gender by the enum‘s ordinal.
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "Please choose gender")
    public Gender gender;

}
