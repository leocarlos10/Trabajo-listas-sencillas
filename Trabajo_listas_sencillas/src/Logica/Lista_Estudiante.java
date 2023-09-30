/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import GUI.Jfrm;
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
                                     //pruebagit mm
    public Lista_Estudiante() {
        cab = null;
    }

    public void setCab(nodo_Estudiante cab) {
        this.cab = cab;
    }

    public nodo_Estudiante getBuscarId(String id) {

        nodo_Estudiante p;

        if (cab == null) {

            return null;
        } else {
            p = cab;
            while (p != null) {
                if (p.getId().equals(id)) {
                    return p;
                } else {
                    p = p.sig;
                }
            }
            return null;
        }
    }

    public nodo_Estudiante getBuscarNombre(String nombre) {

        nodo_Estudiante p;

        if (cab == null) {

            return null;
        } else {
            p = cab;
            while (p != null) {
                if (p.getNombre().equalsIgnoreCase(nombre)) {
                    return p;
                } else {
                    p = p.sig;
                }
            }
            return null;
        }
    }

    public nodo_Estudiante getCrearnod(
            JTextField id,
            JTextField nombre,
            JTextField sexo,
            JTextField edad,
            int curso,
            JTextField nombre_acudiente,
            JTextField t_acudiente
    ) {
        nodo_Estudiante info = null;

        try {
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
                        curso,
                        new Acudiente(nombre_acudiente.getText(), t_acudiente.getText()));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al crear el nodo " + e);
        }
        return info;
    }

    public nodo_Estudiante getUltimo() {

        nodo_Estudiante p;

        if (cab == null) {
            return null;
        } else {
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
            int curso,
            JTextField nombre_acudiente,
            JTextField t_acudiente
    ) {

        nodo_Estudiante info = getCrearnod(id, nombre, sexo, edad, curso, nombre_acudiente, t_acudiente);

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
            int curso,
            JTextField nombre_acudiente,
            JTextField t_acudiente
    ) {
        nodo_Estudiante info = getCrearnod(id, nombre, sexo, edad, curso, nombre_acudiente, t_acudiente);

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
            int curso,
            JTextField nombre_acudiente,
            JTextField t_acudiente,
            String id_nodo_actual
    ) {

        nodo_Estudiante info = getCrearnod(id, nombre, sexo, edad, curso, nombre_acudiente, t_acudiente);

        if (info != null) {
            nodo_Estudiante pos;
            nodo_Estudiante nodo_actual = getBuscarId(id_nodo_actual);
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
                // guardo el posterior al nodo actual
                pos = nodo_actual.sig;
                // hacemos que nodo actual apunte a info
                nodo_actual.sig = info;
                // ahora hacemos que info apunte a el nodo posterior
                info.sig = pos;
                JOptionPane.showMessageDialog(null, ""
                        + "Estudiante se ha agregado en medio de " + nodo_actual.nombre + " y " + pos.nombre);
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

    public void getEstudiante(String id) throws Exception {

        nodo_Estudiante p = getBuscarId(id);
        if (p != null) {
            p.mostrar();
        } else {
            JOptionPane.showMessageDialog(null, "El estudiante no ha sido encontrado");
        }
    }

    public void getBuscarInfo_Acudiente(String nombre) throws Exception {

        nodo_Estudiante p = getBuscarNombre(nombre);
        if (p != null) {
            p.acudiente.mostrar();
        } else {
            JOptionPane.showMessageDialog(null, "Informacion del acudiente no encontrada");
        }
    }

    public void setRegistrarFilaJTable(DefaultTableModel miModelo,
            int Fila, nodo_Estudiante info) {
        miModelo.setValueAt(info.id, Fila, 0);
        miModelo.setValueAt(info.nombre, Fila, 1);
        miModelo.setValueAt(info.sexo, Fila, 2);
        miModelo.setValueAt(info.edad, Fila, 3);
        miModelo.setValueAt(info.curso, Fila, 4);
        miModelo.setValueAt(info.acudiente.nombre, Fila, 5);
        miModelo.setValueAt(info.acudiente.telefono, Fila, 6);
    }

    public void gEstudiantesMayorEdad() {
        int maxEdadPrimero = -1;
        int maxEdadQuinto = -1;

        nodo_Estudiante estudianteMaxPrimero = null;
        nodo_Estudiante estudianteMaxQuinto = null;

        nodo_Estudiante actual = cab;

        while (actual != null) {
            if (actual.getCurso() == 1 && actual.getEdad() > maxEdadPrimero) {
                maxEdadPrimero = actual.getEdad();
                estudianteMaxPrimero = actual;
            } else if (actual.getCurso() == 5 && actual.getEdad() > maxEdadQuinto) {
                maxEdadQuinto = actual.getEdad();
                estudianteMaxQuinto = actual;
            }
            actual = actual.sig;
        }

        if (estudianteMaxPrimero != null) {
            // Muestra el estudiante de mayor edad en el curso primero
            JOptionPane.showMessageDialog(null, "Estudiante de mayor edad en primero:\n\n"
                    + "Nombre: " + estudianteMaxPrimero.getNombre() + "\n"
                    + "Sexo: " + estudianteMaxPrimero.getSexo() + "\n"
                    + "Edad: " + estudianteMaxPrimero.getEdad());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron estudiantes en el curso primero.");
        }

        if (estudianteMaxQuinto != null) {
            // Muestra el estudiante de mayor edad en el curso quinto
            JOptionPane.showMessageDialog(null, "Estudiante de mayor edad en quinto:\n\n"
                    + "Nombre: " + estudianteMaxQuinto.getNombre() + "\n"
                    + "Sexo: " + estudianteMaxQuinto.getSexo() + "\n"
                    + "Edad: " + estudianteMaxQuinto.getEdad());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron estudiantes en el curso quinto.");
        }
    }

    public void setElimCodigo(String id) {

        if (cab == null) {
            JOptionPane.showMessageDialog(null,
                    "La lista no tiene elementos!");
        } else {
            nodo_Estudiante p, anterior = null;
            p = getBuscarId(id);
            if (p == null) {
                JOptionPane.showMessageDialog(null,
                        "El código buscado para eliminar NO"
                        + " se encuentra registrado!");
            } else {
                if ((p == cab) && (cab.sig == null)) {
                    cab = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado, la lista esta vacía!");
                } else if ((p == cab) && (cab.sig != null)) {
                    cab = cab.sig;
                    p.sig = null;
                    p = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado, en el inicio de la"
                            + " lista!");
                } else if (p.sig == null) {
                    anterior = getAnterior(p);
                    anterior.sig = null;
                    p = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado, al final de la"
                            + " lista!");
                } else {
                    anterior = getAnterior(p);
                    anterior.sig = p.sig;
                    p.sig = null;
                    p = null;
                    JOptionPane.showMessageDialog(null,
                            "Elemento eliminado!");
                }
            }
        }
    }

    public void setEliminar_estudiante(JTable tab) {

        String id = JOptionPane.showInputDialog("Ingrese el id del estudiante a eliminar");
        nodo_Estudiante p = getBuscarId(id);

        if (p.curso == 5) {
            String estado_curso = JOptionPane.showInputDialog("""
                                                               El estudiante termino el grado 5 ?
                                                               Escriba si
                                                               o no.
                                                               """);

            if (estado_curso.equalsIgnoreCase("si")) {
                setElimCodigo(id);
                setLlenarJTable(tab);
            } else {
                JOptionPane.showMessageDialog(null, """
                                                     Para poder eliminar al estudiante, antes debe
                                                     terminar el grado 5
                                                     """);
            }
        } else {

            JOptionPane.showMessageDialog(null, """
                                                 El estudiante no se encuentra en el grado 5
                                                 Por tanto no se puede eliminar
                                                 """);
        }
    }

    public void gInfMujeresQuinto() {
        int cantMujeres = 0;
        int sumaEdad = 0;

        nodo_Estudiante actual = cab;

        while (actual != null) {
            if (actual.getCurso() == 5 && actual.getSexo().equalsIgnoreCase("f")) {
                cantMujeres++;
                sumaEdad += actual.getEdad();
                JOptionPane.showMessageDialog(null, "Nombre: " + actual.getNombre());
            }
            actual = actual.sig;
        }

        double edadPromedioMujeresQuintoGrado = 0;
        if (cantMujeres > 0) {
            edadPromedioMujeresQuintoGrado = (double) sumaEdad / cantMujeres;
        }

        JOptionPane.showMessageDialog(null, "Mujeres en quinto grado: " + cantMujeres
                + "\nEdad promedio: " + edadPromedioMujeresQuintoGrado);
    }
    
    public void informePrimerGrado() {
    int totalMujeresPrimerGrado = 0;
    int totalHombresPrimerGrado = 0;
    
    nodo_Estudiante actual = cab;
    
    while (actual != null) {
        if (actual.getCurso() == 1) {
            if (actual.getSexo().equalsIgnoreCase("f")) {
                totalMujeresPrimerGrado++;
            } else if (actual.getSexo().equalsIgnoreCase("m")) {
                totalHombresPrimerGrado++;
            }
        }
        actual = actual.sig;
    }

    JOptionPane.showMessageDialog(null, "Mujeres que ingresan a primer grado: " + totalMujeresPrimerGrado +
            "\nHombres que ingresan a primer grado: " + totalHombresPrimerGrado);
}


    public void setLlenarJTable(JTable tab) {
        nodo_Estudiante p = cab;
        int i = 0;
        DefaultTableModel miModelo = new DefaultTableModel();
        miModelo.addColumn("ID");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Sexo");
        miModelo.addColumn("Edad");
        miModelo.addColumn("curso");
        miModelo.addColumn("Nombre");
        miModelo.addColumn("Teléfono");
        while (p != null) {
            miModelo.addRow(new Object[]{"", "", "", "", ""});
            setRegistrarFilaJTable(miModelo, i, p);
            p = p.sig;
            i++;
        }
        tab.setModel(miModelo);
    }
}
