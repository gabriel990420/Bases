/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author david
 */
public class Cita {
    private int idCita;
    private String diagnostico;
    private String tratamiento; 
    private int valor_cita;
    private String fecha_hora;
    private int idV;
    private int idMas;

    public Cita() {
    }

    public Cita(String diagnostico, String tratamiento, int valor_cita, String fecha_hora, int idV, int idMas) {
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.valor_cita = valor_cita;
        this.fecha_hora = fecha_hora;
        this.idV = idV;
        this.idMas = idMas;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getValor_cita() {
        return valor_cita;
    }

    public void setValor_cita(int valor_cita) {
        this.valor_cita = valor_cita;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getIdV() {
        return idV;
    }

    public void setIdV(int idV) {
        this.idV = idV;
    }

    public int getIdMas() {
        return idMas;
    }

    public void setIdMas(int idMas) {
        this.idMas = idMas;
    }
    

    public boolean insertarCita(String sql) {
        boolean c = false;
        PreparedStatement ps = null;
        ConnectBD objCB = new ConnectBD();
        try{
            if(objCB.crearConexion()){
               objCB.getConexion().setAutoCommit(false);
               ps = objCB.getConexion().prepareStatement(sql);
               ps.setString(1, diagnostico);
               ps.setString(2, tratamiento); 
               ps.setString(3, Integer.toString(valor_cita));
               ps.setString(4, fecha_hora);
               ps.setString(5, Integer.toString(idV));
               ps.setString(6, Integer.toString(idMas));
               ps.executeUpdate();
               objCB.getConexion().commit();
               c=true;               
            }
            try{
                ps.close();
            }catch (SQLException e){
                System.out.println("Error" + e.toString());                
            }
        }catch(SQLException e){
            System.out.println("Error" + e.toString());
        }
        return c;
    }

    public ResultSet obtenerCita(String sql) {
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

    public boolean eliminarCita(String sql) {
        boolean c = false;
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);
            }
            c=true;
        }catch(Exception e){
            System.out.println("Error"+e.toString());
        }
        return c;
    }
    
    public boolean actualizarCita(String sql) {
        boolean c = false;
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);
            }
            c=true;
        }catch(Exception e){
            System.out.println("Error"+e.toString());
        }
        return c;
    }
    
    
}
