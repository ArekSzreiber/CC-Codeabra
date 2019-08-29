package com.codeabra.entity;

import lombok.Data;
import javax.persistence.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Data
@Component
@Entity
@Table(name = "Instructors", schema = "public")
public class Instructor {
}
