package com.gcSpring.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Gas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long measurement;

    @OneToOne
    private Users user;

    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Long measurement) {
        this.measurement = measurement;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
