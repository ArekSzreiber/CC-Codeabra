package com.codeabra.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "Instructors", schema = "public")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer instructorId;


}
