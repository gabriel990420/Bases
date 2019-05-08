/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import control.ConnectBD;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

/**
 *
 * @author david
 */
public class Entrenador {

    private int idEntrenador;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String horarioI;
    private String horarioF;

    public Entrenador() {
    }

    public Entrenador(int idEntrenador, String nombre1, String nombre2, String apellido1, String apellido2, String horarioI, String horarioF) {
        this.idEntrenador = idEntrenador;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.horarioI = horarioI;
        this.horarioF = horarioF;
    }
    
    

    public Entrenador(String nombre1, String apellido1, String horarioI, String horarioF) {
        //constructor de parametros no nulos
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.horarioI = horarioI;
        this.horarioF = horarioF;
    }

    public Entrenador(String nombre1, String nombre2, String apellido1, String apellido2, String horarioI, String horarioF) {
        //contructor con todos los parametros
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.horarioI = horarioI;
        this.horarioF = horarioF;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }
    

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getHorarioI() {
        return horarioI;
    }

    public void setHorarioI(String horarioI) {
        this.horarioI = horarioI;
    }

    public String getHorarioF() {
        return horarioF;
    }

    public void setHorarioF(String horarioF) {
        this.horarioF = horarioF;
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
    
    public ResultSet obtenerEntrenador(String sql){
        ResultSet rs = null;
        
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
                rs = objCB.getStatement().executeQuery(sql);
            }
        }catch(Exception e){
            System.out.println("Error: "+e.toString());
        }
        return rs;
    }

    public boolean eliminarEntrenador(String sql) {
        boolean e = false;
        try{
            ConnectBD objCB = new ConnectBD();
            if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);
            }
            e =true;
        }catch(Exception ex){
            System.out.println("Error"+ex.toString());
        }
        return e;
    }

    public boolean ActualizarEntrenador(String sql) {
              boolean d = false;
       
       try{
           ConnectBD objCB = new ConnectBD();
           if(objCB.crearConexion()){
               objCB.getStatement().executeUpdate(sql);
           }
           d = true;
       }catch(Exception e){
           System.out.println("Error: "+e.toString());
       }
       return d; 
        
    }


}
