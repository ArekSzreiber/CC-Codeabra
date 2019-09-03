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

    @NotNull(message = "{notnull}")
    @Size(min = 3, message = "{min.length}")
    @Column
    private String name;

    @NotNull(message = "{notnull}")
    @Column
    private Weekday weekday;

    @NotNull(message = "{notnull}")
    @Column
    private String time;

    @NotNull(message = "{notnull}")
    @Column
    private String level;


}
