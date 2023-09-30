/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Logica.nodo_Estudiante;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leocarlos y moises
 */
public class Lista_Estudiante {
    
    public nodo_Estudiante cab;
    
    
    public Lista_Estudiante(){cab = null;}

    public void setCab(nodo_Estudiante cab) {
        this.cab = cab;
    }
    
    public nodo_Estudiante getBuscarId(String id){
        
        nodo_Estudiante p;
        
        if(cab==null){
            
            return null;
        }else{
            p=cab;
            while(p!=null){
                if(p.getId().equals(id))
                    return p;
                else
                    p=p.sig;
            }
            return null;
        }
    }
    
   
    public nodo_Estudiante getCrearnod(
            JTextField id,
            JTextField nombre,
            JTextField sexo,
            JTextField edad,
            JTextField nombre_acudiente,
            JTextField t_acudiente
    ){
         nodo_Estudiante info = null;
         
        try{
               nodo_Estudiante buscar = getBuscarId(id.getText());

               if (buscar != null) {

                   JOptionPane.showMessageDialog(null, "ID repetido, Porfavor intente nuevamenete");
                   id.setText("");
                   id.requestFocus();
               } else {

                   info = new nodo_Estudiante(
                           id.getText(),
                           nombre.getText(),
                           sexo.getText(),
                           Integer.parseInt(edad.getText()),
                           new Acudiente(nombre_acudiente.getText(), t_acudiente.getText()));

               }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el nodo "+e);
        }
         return info;
    }
    
   public nodo_Estudiante getUltimo(){
      
       nodo_Estudiante p; 
       
       if(cab==null)
            return null;
        else{
            p = cab;
            while (p.sig != null) {
                p = p.sig;
            }  
        }
       return p;
    }
   
    public void setAddInicio(
            JTextField id,
            JTextField nombre,
            JTextField sexo,
            JTextField edad,
            JTextField nombre_acudiente,
            JTextField t_acudiente 
        ){
        
        nodo_Estudiante info= getCrearnod(id, nombre, sexo, edad, nombre_acudiente, t_acudiente);
        
        if (info != null) {
            if (cab == null) {
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Estudiante agregado, Lista estaba vacia ");
                id.setText("");
                    nombre.setText("");
                    sexo.setText("");
                    edad.setText("");
                    nombre_acudiente.setText("");
                    t_acudiente.setText("");
                    id.requestFocus();
            } else {
                
                info.sig = cab;
                cab = info;
                JOptionPane.showMessageDialog(null,
                        "Estudiante agregado al inicio de la lista.");
                id.setText("");
                    nombre.setText("");
                    sexo.setText("");
                    edad.setText("");
                    nombre_acudiente.setText("");
                    t_acudiente.setText("");
                    id.requestFocus();
            }
        }
    }
    
    
    public void setAgregarfinal(
            JTextField id,
            JTextField nombre,
            JTextField sexo,
            JTextField edad,
            JTextField nombre_acudiente,
            JTextField t_acudiente
    ){
            nodo_Estudiante info = getCrearnod(id, nombre, sexo, edad, nombre_acudiente, t_acudiente);

            if (info != null) {

                if (cab == null) {
                    cab = info;
                    JOptionPane.showMessageDialog(null, "Estudiante agregado, Lista estaba vacia");
                    id.setText("");
                    nombre.setText("");
                    sexo.setText("");
                    edad.setText("");
                    nombre_acudiente.setText("");
                    t_acudiente.setText("");
                    id.requestFocus();
                } else {
                    nodo_Estudiante ultimo = getUltimo();
                    ultimo.sig = info;
                    JOptionPane.showMessageDialog(null, "Estudiante agregado");
                    id.setText("");
                    nombre.setText("");
                    sexo.setText("");
                    edad.setText("");
                    nombre_acudiente.setText("");
                    t_acudiente.setText("");
                    id.requestFocus();
                }
            }
    }
        
    public nodo_Estudiante getAnterior(nodo_Estudiante actual) {

        nodo_Estudiante anterior = null;
        if (cab == null) {
            return null;
        } else {
            anterior = cab;
            while (anterior.sig != actual) {
                anterior = anterior.sig;
            }
            return anterior;
        }
    }
    
    
    public void setAgregar_centro(
            JTextField id,
            JTextField nombre,
            JTextField sexo,
            JTextField edad,
            JTextField nombre_acudiente,
            JTextField t_acudiente,
            String id_nodo_actual
    ){
      
        nodo_Estudiante info = getCrearnod(id, nombre, sexo, edad, nombre_acudiente, t_acudiente);
        
        if(info!= null){
            nodo_Estudiante pos;
            nodo_Estudiante nodo_actual=getBuscarId(id_nodo_actual);
            if(cab==null){
                
                cab=info;
                JOptionPane.showMessageDialog(null, "Estudiante agregado, Lista estaba vacia");
                id.setText("");
                    nombre.setText("");
                    sexo.setText("");
                    edad.setText("");
                    nombre_acudiente.setText("");
                    t_acudiente.setText("");
                    id.requestFocus();
            }else{
                // guardo el posterior al nodo actual
                pos=nodo_actual.sig;
                // hacemos que nodo actual apunte a info
                nodo_actual.sig=info;
                // ahora hacemos que info apunte a el nodo posterior
                info.sig=pos;
                JOptionPane.showMessageDialog(null, ""
                        + "Estudiante se ha agregado en medio de "+nodo_actual.nombre+" y "+pos.nombre);
                id.setText("");
                    nombre.setText("");
                    sexo.setText("");
                    edad.setText("");
                    nombre_acudiente.setText("");
                    t_acudiente.setText("");
                    id.requestFocus();
            }
        }
    }
    
    public void getEstudiante(String id){
         
       nodo_Estudiante p = getBuscarId(id);
       if(p!=null)
           p.mostrar();
       else
           JOptionPane.showMessageDialog(null, "El estudiante no ha sido encontrado");
    }
    
    
    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
        int Fila, nodo_Estudiante info){
        miModelo.setValueAt(info.id, Fila, 0);
        miModelo.setValueAt(info.nombre, Fila, 1);
        miModelo.setValueAt(info.sexo, Fila, 2);
        miModelo.setValueAt(info.edad, Fila, 3);
        miModelo.setValueAt(info.acudiente.nombre, Fila, 4);
        miModelo.setValueAt(info.acudiente.telefono, Fila, 5);
    }
    
    public void setLlenarJTable(JTable tab){
        nodo_Estudiante p=cab;
        int i=0;
        DefaultTableModel miModelo=new DefaultTableModel();
        miModelo.addColumn("ID");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Sexo");
        miModelo.addColumn("Edad");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Teléfono");
        while(p!=null){                        
            miModelo.addRow(new Object[]{"", "", "", "", ""});              
            setRegistrarFilaJTable(miModelo,i,p);
            p=p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }
}
