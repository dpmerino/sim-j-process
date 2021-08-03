package com.STESAJ.processservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name= "process")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder

public class Process {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY) //autoincrement
    private long process_id;
    
    @NotEmpty(message = "El nombre no debe ser vacío")
    private String nombre_proc;
    @NotEmpty(message = "La descripcion no debe ser vacía")
    private String desc_proc;
}
