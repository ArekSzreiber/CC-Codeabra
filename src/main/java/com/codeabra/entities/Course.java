package com.codeabra.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Enumerated
    //@Pattern(regexp = "\\b(?:MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY)\\b", message = "To nie jest poprawny dzień tygodnia!")
    private Weekday weekday;

    @NotNull(message = "{notnull}")
    @Column
    @Enumerated
    //@Pattern(regexp = "\\b(?:TEN|TWELVE|FOURTEEN|SIXTEEN|EIGHTEEN|TWENTY)\\b", message = "To nie jest poprawna godzina!")
    private Time time;

    @NotNull(message = "{notnull}")
    @Column
    private String level;

}
