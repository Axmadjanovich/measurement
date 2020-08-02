package com.gcSpring.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fname;

    private String lname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFName() {
        return fname;
    }

    public void setFName(String FName) {
        this.fname = FName;
    }

    public String getLName() {
        return lname;
    }

    public void setLName(String LName) {
        this.lname = LName;
    }
}
