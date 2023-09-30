/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JOptionPane;

           
/**
 *
 * @author Leocarlos y moises
 * 
 */
public class nodo_Estudiante {
    
    String id;
    String nombre;
    String sexo;
    int edad;
    int curso;
    Acudiente acudiente;
    nodo_Estudiante sig;

    public nodo_Estudiante(String id, String nombre, String sexo, int edad, int curso, Acudiente acudiente) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.curso = curso;
        this.acudiente = acudiente;
    }

   
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    
    
    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }
    
    public void mostrar(){
        
        String info ="""
                     Info del estudiante con id: """ + id +
                "\n" 
                + "\n nombre: " + nombre
                + "\n sexo: " + sexo
                + "\n edad: " + edad
                + "\n nombre del acudiente: " + acudiente.nombre
                + "\n telefono del acudiente: "+acudiente.telefono;
                
        JOptionPane.showMessageDialog(null, info);
    }  
}
