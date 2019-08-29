package com.codeabra.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.util.HashSet;

@Data
@Component
@Entity
@Table(name = "Courses", schema = "public")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int courseId;

    @NotNull(message = "pole wymagane")
    @Size(min = 3, message = "wymagane min. 3 znaki")
    @Column(name = "name")
    private String name;

    @NotNull(message = "pole wymagane")
    @Column(name = "dayOfWeek")
    private String dayOfWeek;

    @DateTimeFormat(pattern = "hh:mm")
    @NotNull(message = "pole wymagane")
    @Column(name = "time")
    private Time time;

    @NotNull(message = "pole wymagane")
    @Size(min = 2, message = "wymagane min. 2 znaki")
    @Column(name = "level")
    private String level;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Instructors_Courses",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "instructor_id")}
    )
    Set<Instructor> instructors = new HashSet<>();


}
