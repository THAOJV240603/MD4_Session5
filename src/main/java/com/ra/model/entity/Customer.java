package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", length = 50)
    private String fullName;
    @Column(name = "email", length = 50, unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    private LocalDate birthday;
}
