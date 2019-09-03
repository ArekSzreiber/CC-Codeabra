package com.codeabra.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Table(name = "students", schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;

    //Actually, we don’t have to specify the @Enumerated annotation at all if we are going to persist the Role by the enum‘s ordinal.
    @Enumerated(EnumType.ORDINAL)
    @NotNull(message = "{notnull.role}")
    public Role role;

}
