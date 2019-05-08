/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.ResultSet;
import modelo.Entrenamientos;

/**
 *
 * @author david
 */
public class ControlEntrenamientos {

    public static boolean insertarEntrenamiento(Entrenamientos objE) {
        boolean m;
        String nombre;
        String valor;
        String duracion;

        nombre = "'" + objE.getNombre() + "'";
        valor = Integer.toString(objE.getValor());
        duracion = Integer.toString(objE.getDuracion());

        String sql = "INSERT INTO entrenamientos(nombre, valor, duracion) values(" + nombre + "," + valor + "," + duracion + ")";
        m = objE.insertarEntrenamientos(sql);
        return m;

    }

    public static Entrenamientos obtenerEntrenamiento(int identrenamientos) {

        Entrenamientos objE = new Entrenamientos();
        String sql = "SELECT * FROM entrenamientos WHERE identrenamientos = " + identrenamientos;
        ResultSet rs = objE.obtenerEntrenamiento(sql);

        String nombre;
        int valor, duracion;

        if (rs == null) {
            objE = null;
        } else {
            try {
                rs.next();
                nombre = rs.getString("nombre");
                valor = rs.getInt("valor");
                duracion = rs.getInt("duracion");

                objE = new Entrenamientos(identrenamientos, nombre, valor, duracion);

            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }

        return objE;
    }

    public static boolean EliminarEntrenamiento(int idEntrenamiento) {
        boolean d;
        Entrenamientos objE = new Entrenamientos();
        String sql = "delete from entrenamientos where idEntrenamientos= " + Integer.toString(idEntrenamiento);
        d = objE.EliminarEntrenamiento(sql);
        return d;

    }
    
    public static boolean actualizarEntrenamiento(Entrenamientos objE){
        boolean e;
        String identrenamientos, nombre, valor, duracion;
        
        identrenamientos = Integer.toString(objE.getIdentrenamientos());
        nombre = "'"+objE.getNombre()+"'";
        valor = Integer.toString(objE.getValor());
        duracion = Integer.toString(objE.getDuracion());
        
        String sql = "update entrenamientos set "
                + "nombre = "+nombre+", valor = "+valor+", duracion = "+duracion+" where identrenamientos = "+identrenamientos;
        e = objE.actualizarEntrenamiento(sql);
        return e;
    }

}
