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
    @NotNull(message = "{notempty}")
    @Size(min = 2, message = "{min.length}")
    @Size(max = 15, message = "{max.length}")
    public String name;

    @Column
    @NotNull(message = "{notempty}")
    @Size(min = 2, message = "{min.length}")
    @Size(max = 30, message = "{max.length}")
    public String surname;

    @Column
    @Size(max = 254)
    @Size(min = 2, message = "{email.notempty}")
    public String emailAddress;

    @Column
    public String phoneNumber;

}
