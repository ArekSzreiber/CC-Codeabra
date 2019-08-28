package com.codeabra.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;

@Data
@Component
@Entity
@Table(name = "courses", schema = "public")
public class Course {

    @NotNull(message = "pole wymagane")
    @Size(min = 3, message = "wymagane min. 3 znaki")
    @Column(name = "name")
    private String name;

    @NotNull(message = "pole wymagane")
    @Size(min = 3, message = "wymagane min. 3 znaki")
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


}
