package com.api.persona.model;


import javax.persistence.*;


@Entity
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id",unique=true,nullable=false)
    private Long id;

    @Column(name="dni",nullable=false)
    private String dni;

    @Column(name="nombre",nullable=false)
    private String nombre;

    @Column(name="apellidos",nullable=false)
    private String apellidos;

    @Column(name="empleado",nullable=false)
    private boolean empleado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isEmpleado() {
        return empleado;
    }

    public void setEmpleado(boolean empleado) {
        this.empleado = empleado;
    }
}
