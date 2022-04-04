package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import java.sql.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @Column(name="fullname")
    @NotBlank(message="Name cannot be blank")
    private String name;

    @NotBlank(message="Email cannot be blank")
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="dateOfBirth")
    private String birthday;

    @Column(name="gender")
    private String gender;

    @Column(name="profession")
    private String profession;

    @Column(name="married")
    private Boolean married;

    @Column(name="note")
    private String note;

    public User() {}

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String  getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getBirthday() {
        return this.birthday;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getProfession() {
        return this.profession;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return this.note;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }
    public Boolean getMarried() {
        return this.married;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return this.gender;
    }


    @Override
    public String toString() {
        return "";
    }
}
