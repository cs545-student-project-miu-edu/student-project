package edu.miu.cs545.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private Address address;
    boolean blackListed;
    @ManyToOne(fetch = FetchType.LAZY)
    Administrator blackListedBy;
    @OneToOne(fetch = FetchType.LAZY)
    User user;
}
