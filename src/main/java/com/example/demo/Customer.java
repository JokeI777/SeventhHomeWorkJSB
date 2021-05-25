package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> events;

    public Customer(String name, List<String> events){
        this.name = name;
        this.events = events;
    }

    protected Customer(){}
    public List<String> getEvents() {
        return events;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }
}
