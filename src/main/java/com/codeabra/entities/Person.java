package com.codeabra.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Column
    @NotNull(message = "Cannot be empty")
    @Size(min = 2, message = "Minimum length is 2")
    @Size(max = 15, message = "Maximum length is 15")
    public String name;

    @Column
    @NotNull(message = "Cannot be empty")
    @Size(min = 2, message = "Minimum length is 2")
    @Size(max = 30, message = "Maximum length is 30")
    public String surname;

    @Column
    @Size(max = 254)
    public String emailAddress;

    @Column
    public String phoneNumber;

}
