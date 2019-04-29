/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Entrenador;

/**
 *
 * @author david
 */
public class ControlEntrenador {

    public static boolean insertarEntrenador(Entrenador objE) {
        boolean d;
        String nombre1, nombre2, apellido1, apellido2, HorarioI, HorarioF;

        nombre1 = "'" + objE.getNombre1() + "'";

        if (objE.getNombre2().equals("default")) {
            nombre2 = objE.getNombre2();
        } else {
            nombre2 = "'" + objE.getNombre2() + "'";
        }

        apellido1 = "'" + objE.getApellido1() + "'";

        if (objE.getApellido2().equals("default")) {
            apellido2 = objE.getApellido2();
        } else {
            apellido2 = "'" + objE.getApellido2()+ "'";
        }

        HorarioI = "'" + objE.getHorarioI() + "'";
        HorarioF = "'" + objE.getHorarioF() + "'";

        String sql = "INSERT INTO entrenador (nombre1, nombre2, apellido1, apellido2, horarioI, horarioF) values(" + nombre1 + ", " + nombre2 + ", " + apellido1
                + ", " + apellido2 + ", " + HorarioI + ", " + HorarioF + ")";
        d = objE.insertarEntrenador(sql);
        return d;
    }

    public static Entrenador obtenerEntrenador(int identrenador) {
        Entrenador objE = new Entrenador();

        String nombre1, nombre2, apellido1, apellido2, horarioI, horarioF;
        String sql = "SELECT * FROM entrenador where identrenador = " + identrenador;
        ResultSet rs = objE.obtenerEntrenador(sql);

        if (rs == null) {
            objE = null;
        } else {
            try {
                rs.next();
                nombre1 = rs.getString("nombre1");
                nombre2 = rs.getString("nombre2");
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                horarioI = rs.getString("horarioI");
                horarioF = rs.getString("horarioF");

                if (nombre2 == null) {
                    nombre2 = "";
                }
                if (apellido2 == null) {
                    apellido2 = "";
                }

                objE = new Entrenador(identrenador, nombre1, nombre2, apellido1, apellido2, horarioI, horarioF);

            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }

        return objE;
    }

    public static boolean eliminarEntrenador(int idEntrenador) {
        boolean e;
        Entrenador objE = new Entrenador();

        String sql = "DELETE FROM entrenador WHERE idEntrenador =" + Integer.toString(idEntrenador);
        e = objE.eliminarEntrenador(sql);
        return e;
    }

    public static boolean ActualizarEntrenador(Entrenador objE) {
        boolean b;
        String idEntrenador;
        String nombre1;
        String nombre2;
        String apellido1;
        String apellido2;
        String horarioI;
        String horarioF;

        idEntrenador = Integer.toString(objE.getIdEntrenador());
        nombre1 = "'" + objE.getNombre1() + "'";
        nombre2 = "'" + objE.getNombre2() + "'";
        apellido1 = "'" + objE.getApellido1() + "'";
        apellido2 = "'" + objE.getApellido2() + "'";
        horarioI = "'" + objE.getHorarioI() + "'";
        horarioF = "'" + objE.getHorarioF() + "'";
        
        String sql="update Entrenador set " +" nombre1= "+nombre1+", nombre2= "+ nombre2+
                ", apellido1= "+apellido1+", apellido2= "+ apellido2+
                ", horarioI= "+horarioI+", horarioF= "+horarioF+" where identrenador= "+idEntrenador;
        
        b = objE.ActualizarEntrenador(sql);
        return b;

    }
}
