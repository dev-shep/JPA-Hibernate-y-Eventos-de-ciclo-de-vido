/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.curso.spriingboot.jpa.springbot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Limon
 */

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String lastname;
    
    @Column(name="programming_languague")
    private String programmingLanguage;
    
    @Embedded
    private Audit audit = new Audit();

    public Person() {
    }

    public Person(Long id, String name, String lastname, String programmingLanguage) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLanguage = programmingLanguage;
    }

    public Person(String lastname, String name) {
        this.lastname = lastname;
        this.name = name;
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
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", lastname=").append(lastname);
        sb.append(", programmingLanguage=").append(programmingLanguage);
        sb.append(", createAt=").append(audit.getCreateAt());
        sb.append(", updateAt=").append(audit.getUpdateAt());
        sb.append('}');
        return sb.toString();
    }



    
}
