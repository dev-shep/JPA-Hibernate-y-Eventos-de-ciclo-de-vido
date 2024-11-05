/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.curso.spriingboot.jpa.springbot_jpa.dto;

/**
 *
 * @author Limon
 */
public class PersonDto {
    private String name;
    private String lastname;

    public PersonDto() {
    }

    public PersonDto(String lastname, String name) {
        this.lastname = lastname;
        this.name = name;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonDto{");
        sb.append("name=").append(name);
        sb.append(", lastname=").append(lastname);
        sb.append('}');
        return sb.toString();
    }

}
