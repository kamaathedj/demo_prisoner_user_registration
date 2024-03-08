package com.example.demo.warden;

import jakarta.persistence.*;

@Entity
@Table(name="warden")
public record Warden(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id int id ,
        String name,
        String password,
        int NumberOfPrisoner,
        @Column(name = "isAdmin", columnDefinition = "boolean default true")
        boolean isAdmin
){

}
