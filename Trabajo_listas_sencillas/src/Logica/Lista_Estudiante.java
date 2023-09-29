/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author USUARIO
 */
public class Lista_Estudiante {
    
    nodo_Estudiante cab;
    
    public Lista_Estudiante(){cab = null;}
    
    
    public nodo_Estudiante getBuscarId(String id){
        nodo_Estudiante p;
        
        if(cab == null){
            
            return null;
        }else{
            
            p=cab;
            while(cab!= null){
                
                if(cab.getId().equals(id)){
                    return p;
                }else{
                    p=p.sig;
                }   
            }
            return null;
        }
    }
    
   
    public nodo_Estudiante getCrearnod(
            JTextField id,
            JTextField nombre,
            String sexo,
            JTextField edad,
            JTextField nombre_acudiente,
            JTextField t_acudiente
            
            
    ){
        nodo_Estudiante buscar = getBuscarId(id.getText());
        nodo_Estudiante info = null;
        
        if(buscar != null){
            
            JOptionPane.showMessageDialog(null, "ID repetido, Porfavor intente nuevamenete");
            id.setText("");
            id.requestFocus();
        }else{
            try{
            info = new nodo_Estudiante(
                    id.getText(),
                    nombre.getText(),
                    sexo,
                    Integer.parseInt(edad.getText()),
                    new Acudiente(nombre_acudiente.getText(),t_acudiente.getText()));
            }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Error"+e);
            }
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
    
    public void setAgregarfinal(
            JTextField id,
            JTextField nombre,
            String sexo,
            JTextField edad,
            JTextField nombre_acudiente,
            JTextField t_acudiente
    ){
        
        nodo_Estudiante info = getCrearnod(id, nombre, sexo, edad, nombre_acudiente, t_acudiente);
        
        if(info!= null){
            
            if(cab==null){
                cab=info;
                JOptionPane.showMessageDialog(null, "Estudiante agregado, Lista estaba vacia");
            }else{
                nodo_Estudiante ultimo = getUltimo();
                ultimo.sig=info;
                JOptionPane.showMessageDialog(null, "Estudiante agregado");
            }
        }
    }
}
