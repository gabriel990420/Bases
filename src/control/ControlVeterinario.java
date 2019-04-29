/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Veterinario;

/**
 *
 * @author david
 */
public class ControlVeterinario {

 public static boolean insertarVeterinario(Veterinario objE) {
        boolean d;
        String nombre1, nombre2, apellido1, apellido2, especialidad;

        nombre1 = "'" + objE.getNombre1v() + "'";

        if (objE.getNombre2v().equals("default")) {
            nombre2 = objE.getNombre2v();
        } else {
            nombre2 = "'" + objE.getNombre2v() + "'";
        }

        apellido1 = "'" + objE.getApellido1v() + "'";

        if (objE.getApellido2v().equals("default")) {
            apellido2 = objE.getApellido2v();
        } else {
            apellido2 = "'" + objE.getApellido2v()+ "'";
        }
        especialidad= "'"+objE.getEspecialidad()+"'";


        String sql = "INSERT INTO veterinario (nombre1, nombre2, apellido1, apellido2, especialidad) values(" + nombre1 + ", " + nombre2 + ", " + apellido1
                + ", " + apellido2 + ", " + especialidad + ")";
        d = objE.insertarEntrenador(sql);
        return d;
    }

    public static Veterinario obtenerVeterinario(int idVeterinario) {
        Veterinario objV = new Veterinario();

        String nombre1;
        String nombre2;
        String apellido1;
        String apellido2;
        String especialidad;

        String sql = "SELECT * FROM veterinario WHERE idveterinario=" + Integer.toString(idVeterinario);
        ResultSet rs = objV.obtenerVeterinario(sql);
        if (rs == null) {
            objV = null;
        } else {
            try {
                rs.next();
                nombre1 = rs.getString("nombre1");
                nombre2 = rs.getString("nombre2");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                especialidad = rs.getString("especialidad");

                objV = new Veterinario(nombre1, nombre2, apellido1, apellido2, especialidad);
                objV.setIdVeterinario(idVeterinario);
            } catch (Exception e) {
                System.out.println("Error:" + e.toString());
            }
        }
        return objV;
    }

    public static boolean eliminarVeterinario(int idVeterinario) {
        boolean v;
        Veterinario objV = new Veterinario();

        String sql = "DELETE FROM veterinario WHERE idveterinario =" + Integer.toString(idVeterinario);
        v = objV.eliminarVeterinario(sql);
        return v;
    }

    public static boolean ActualizarVeterinario(Veterinario objV) {
        boolean b;
        String nombre1v, nombre2v, apellido1v, apellido2v, especialidad, idVeterinario;
        nombre1v = "'" + objV.getNombre1v() + "'";
        nombre2v = "'" + objV.getNombre2v() + "'";
        apellido1v = "'" + objV.getApellido1v() + "'";
        apellido2v = "'" + objV.getApellido2v() + "'";
        especialidad = "'" + objV.getEspecialidad() + "'";
        idVeterinario = Integer.toString(objV.getIdVeterinario());
        String sql = "update Veterinario set " + "nombre1= " + nombre1v + ", nombre2 =" + nombre2v
                + ", apellido1= " + apellido1v + ", apellido2= " + apellido2v + ", especialidad= "
                + especialidad + "where idveterinario= " + idVeterinario;
        b=objV.ActualizarVeterinario(sql);
        return b;

    }
}
