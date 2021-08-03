package com.STESAJ.processservice.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "actions")
@Data
@AllArgsConstructor  @NoArgsConstructor  @Builder
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private long actions_id;
    @NotEmpty(message = "El nombre no debe ser vacío")
    private String nombre_act;

    @NotEmpty(message = "La descripcion no debe ser vacía")
    private String desc_act;

    @NotNull(message = "El numero de pasos no puede ser vacio")
    private int n_steps;

    @ManyToOne(fetch = FetchType.LAZY) //relacion entre tablas
    @JoinColumn(name = "process_id") //mapeo de la columna proceso
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @NotNull(message = "El proceso no puede ser vacio")
    private Process process;
}
