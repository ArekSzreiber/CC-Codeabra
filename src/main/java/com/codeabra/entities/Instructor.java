package com.codeabra.entities;

import lombok.Data;
import javax.persistence.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Component
@Entity
@Table(name = "Instructors", schema = "public")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int instructorId;

    @Column
    @NotNull(message = "Name can not be empty")
    @Size(min = 2, max = 15)
    public String name;

    @Column
    @NotNull
    @Size(min = 2, max = 30)
    public String surname;

    @Column
    public String emailAddress;

    @Column
    public String phoneNumber;//add regex //@Pattern(regexp = "^(\\+\\d\\d)? ?\\d{9}$")
/*    //Actually, we don’t have to specify the @Enumerated annotation at all if we are going to persist the Gender by the enum‘s ordinal.
    @Enumerated(EnumType.ORDINAL)
    public Gender gender;*/

/*    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "instructorsCourses")
    private Set<Course> courses = new HashSet<>();*/

}
