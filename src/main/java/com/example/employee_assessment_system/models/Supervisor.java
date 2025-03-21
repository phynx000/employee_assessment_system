package com.example.employee_assessment_system.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supervisor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String position;
    private String department;

    public Supervisor() {
    }

    public Supervisor(String name, String position, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
