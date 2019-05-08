/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Mascota_Entrenamiento {
    private int idME, totalPagar, idMas, idEn;
    private String fecha_inscripcion;

    public Mascota_Entrenamiento() {
    }

    public Mascota_Entrenamiento(int totalPagar, int idMas, int idEn, String fecha_inscripcion) {
        this.totalPagar = totalPagar;
        this.idMas = idMas;
        this.idEn = idEn;
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public Mascota_Entrenamiento(int idME, int totalPagar, int idMas, int idEn, String fecha_inscripcion) {
        this.idME = idME;
        this.totalPagar = totalPagar;
        this.idMas = idMas;
        this.idEn = idEn;
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getIdME() {
        return idME;
    }

    public void setIdME(int idME) {
        this.idME = idME;
    }

    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }

    public int getIdMas() {
        return idMas;
    }

    public void setIdMas(int idMas) {
        this.idMas = idMas;
    }

    public int getIdEn() {
        return idEn;
    }

    public void setIdEn(int idEn) {
        this.idEn = idEn;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    @Override
    public String toString() {
        return "Mascota_Entrenamiento{" + "idME=" + idME + ", totalPagar=" + totalPagar + ", idMas=" + idMas + ", idEn=" + idEn + ", fecha_inscripcion=" + fecha_inscripcion + '}';
    }



    public boolean insertarMascota_Entrenamiento(String sql) {
        boolean ME = false;
        PreparedStatement ps = null;
        ConnectBD objCB = new ConnectBD();
        try{
            if(objCB.crearConexion()){
               objCB.getConexion().setAutoCommit(false);
               ps = objCB.getConexion().prepareStatement(sql);
               ps.setString(1, Integer.toString(totalPagar));
               ps.setString(2, fecha_inscripcion);
               ps.setString(3, Integer.toString(idMas));
               ps.setString(4, Integer.toString(idEn));
               ps.executeUpdate();
               objCB.getConexion().commit();
               ME=true;                             
            }
            try{
                ps.close();
            }catch(SQLException e){
                System.out.println("Error"+e.toString());
            }
        }catch(SQLException e){
            System.out.println("Error"+e.toString());
        }
        return ME;        
    }

    public ResultSet obtenerMascota_Entrenamiento(String sql) {
        ResultSet rs = null;

        try {
            ConnectBD objCB = new ConnectBD();

            if (objCB.crearConexion()) {
                rs = objCB.getStatement().executeQuery(sql);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return rs;
    }
       
    
    
}
