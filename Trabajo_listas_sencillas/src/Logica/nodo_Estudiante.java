/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
                  // zzz
/**
 *
 * @author USUARIO
 */
public class nodo_Estudiante {
    
    String id;
    String nombre;
    enum sexo {MASCULINO,FEMENINO}
    int edad;
    Acudiente acudiente;
    nodo_Estudiante sig;

    public nodo_Estudiante(String id, int edad, Acudiente acudiente) {
        this.id = id;
        this.edad = edad;
        this.acudiente = acudiente;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }
    
    
}
