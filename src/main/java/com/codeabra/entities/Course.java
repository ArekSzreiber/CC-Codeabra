package com.codeabra.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Component
@Entity
@Table(name = "Courses", schema = "public")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int courseId;

    @NotNull(message = "pole wymagane")
    @Size(min = 3, message = "wymagane min. 3 znaki")
    @Column
    private String name;

    @NotNull(message = "pole wymagane")
    @Column
    private String dayOfWeek;

    //@DateTimeFormat(pattern = "hh:mm")
    @NotNull(message = "pole wymagane")
    @Column
    private String time;

    @NotNull(message = "pole wymagane")
    //@Size(min = 2, message = "wymagane min. 2 znaki")
    @Column
    private String level;

    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "instructors_courses",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "instructor_id")}
    )
    Set<Instructor> instructorsCourses = new HashSet<>();*/


}
