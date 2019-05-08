/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Duenio;

/**
 *
 * @author david
 */
public class ControlDuenio {

    public static boolean insertarDuenio(Duenio objd) {
        String idDuenio = Integer.toString(objd.getIdDuenio());
        String nombre1 = "'" + objd.getNombre1() + "'";
        String nombre2;
        if (objd.getNombre2().equals("default")) {
            nombre2 = objd.getNombre2();
        } else {
            nombre2 = "'" + objd.getNombre2() + "'";
        }
        String apellido1 = "'" + objd.getApellido1() + "'";
        String apellido2;
        if (objd.getAppelido2().equals("default")) {
            apellido2 = objd.getAppelido2();
        } else {
            apellido2 = "'" + objd.getAppelido2() + "'";
        }
        String direccion = "'" + objd.getDireccion() + "'";
        String correo = "'" + objd.getCorreo() + "'";
        //String 
        String sql = "INSERT INTO duenio (idDuenio, nombre1, nombre2, apellido1, apellido2, direccion, correo) values("+ idDuenio +", " + nombre1 + ", " + nombre2 + ", " + apellido1 + "," + apellido2 + ", " + direccion + "," + correo + ")";
        boolean f = objd.insertarDuenio(sql);
        return f;

    }

    public static Duenio obtenerDuenio(int idDuenio) {
        Duenio objd = new Duenio();

        String nombre1, nombre2, apellido1, apellido2, direccion, correo;
        String sql = "SELECT * FROM Duenio WHERE idDuenio=" + idDuenio;
        ResultSet rs = objd.obtenerDuenio(sql);

        if (rs == null) {
            objd = null;
        } else {
            try {
                rs.next();
                nombre1 = rs.getString("nombre1");
                nombre2 = rs.getString("nombre2");     
                apellido1 = rs.getString("apellido1");
                apellido2 = rs.getString("apellido2");
                direccion = rs.getString("direccion");
                correo = rs.getString("correo");

                if (nombre2 == null) {
                    nombre2 = "default";
                }
                if (apellido2 == null) {
                    apellido2 = "default";
                }

                objd = new Duenio(idDuenio, nombre1, nombre2, apellido1, apellido2, direccion, correo);

            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }

        return objd;
    }

    public static boolean eliminarDuenio(int idDuenio) {
        boolean d;
        Duenio objD = new Duenio();

        String sql = "DELETE FROM duenio WHERE idDuenio =" + Integer.toString(idDuenio);
        d = objD.eliminarDuenio(sql);
        return d;
    }

    public static boolean actualizardueño(Duenio duenio) {
        boolean b;

        String idDuenio, nombre1, nombre2, apellido1, apellido2, direccion, correo;
        idDuenio = Integer.toString(duenio.getIdDuenio());
        nombre1 = "'" + duenio.getNombre1() + "'";
        nombre2 = "'" + duenio.getNombre2() + "'";
        apellido1 = "'" + duenio.getApellido1() + "'";
        apellido2 = "'" + duenio.getAppelido2() + "'";
        direccion = "'" + duenio.getDireccion() + "'";
        correo = "'" + duenio.getCorreo() + "'";

        String sql = "update duenio set "
                + "nombre1 = " + nombre1 + ", nombre2 = " + nombre2 + ", apellido1 = " + apellido1 + ", apellido2 = " + apellido2
                +", direccion = "+direccion+", correo = "+correo + "where idDuenio = "+idDuenio;
        b = duenio.ActualizarDuenio(sql);
        return b;
    }
}
