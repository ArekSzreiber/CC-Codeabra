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

    @NotNull(message = "pole wymagane")
    @Column
    private String time;

    @NotNull(message = "pole wymagane")
    @Column
    private String level;



}
