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
public class Veterinario {
    private int idVeterinario; 
    private String nombre1v, nombre2v, apellido1v, apellido2v, especialidad;

    public Veterinario() {
    }

    public Veterinario( String nombre1v, String nombre2v, String apellido1v, String apellido2v, String especialidad) {
        
        this.nombre1v = nombre1v;
        this.nombre2v = nombre2v;
        this.apellido1v = apellido1v;
        this.apellido2v = apellido2v;
        this.especialidad = especialidad;
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombre1v() {
        return nombre1v;
    }

    public void setNombre1v(String nombre1v) {
        this.nombre1v = nombre1v;
    }

    public String getNombre2v() {
        return nombre2v;
    }

    public void setNombre2v(String nombre2v) {
        this.nombre2v = nombre2v;
    }

    public String getApellido1v() {
        return apellido1v;
    }

    public void setApellido1v(String apellido1v) {
        this.apellido1v = apellido1v;
    }

    public String getApellido2v() {
        return apellido2v;
    }

    public void setApellido2v(String apellido2v) {
        this.apellido2v = apellido2v;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "idVeterinario=" + idVeterinario + ", nombre1v=" + nombre1v + ", nombre2v=" + nombre2v + ", apellido1v=" + apellido1v + ", apellido2v=" + apellido2v + ", especialidad=" + especialidad + '}';
    }

    public boolean insertarEntrenador(String sql) {
        boolean d = false;
        ConnectBD objCB = new ConnectBD();

        try {
            if (objCB.crearConexion()) {
                Statement sentencia = objCB.getConexion().createStatement();
                sentencia.executeUpdate(sql);
            }
            d = true;
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
        return d;
    }

    public ResultSet obtenerVeterinario(String sql) {
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

    public boolean eliminarVeterinario(String sql) {
        boolean ve=false;
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);               
            }
            ve=true;
        }catch(Exception e){
            System.out.println("Error"+e.toString());
        }
        return ve;
    }

    public boolean ActualizarVeterinario(String sql) {
                boolean d=false;
       try{
           ConnectBD connectdb= new ConnectBD();
           if(connectdb.crearConexion()){
            connectdb.getStatement().executeUpdate(sql);
           
               
           }
            d=true;
       }catch(Exception e){
           System.out.println("ERROR: "+e);
           
       }
        
        return d;
    }
    
}
    

