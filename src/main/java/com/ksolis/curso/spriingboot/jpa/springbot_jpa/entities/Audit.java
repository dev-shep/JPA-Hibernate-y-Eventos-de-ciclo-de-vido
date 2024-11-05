/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.ksolis.curso.spriingboot.jpa.springbot_jpa.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

/**
 *
 * @author Limon
 */
@Embeddable
public class Audit {

    @Column(name="create_at")
    private LocalDateTime createAt; 
    
    @Column(name="update_at")
    private LocalDateTime updateAt;


    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }


    @PrePersist
    public void prePersist(){
        System.out.println("Evento del ciclod e vida del entity pre persist");
        this.createAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        System.out.println("Evento del ciclod e vida del entity pre persist");
        this.updateAt = LocalDateTime.now();
    }
}
