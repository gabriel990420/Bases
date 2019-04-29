/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Mascota;

/**
 *
 * @author david
 */
public class ControlMascota {
    
//    public static boolean insertarMascota(Mascota objM, ConnectBD objCB){
//        boolean m;
//        String edad, idD, idR;
//        String nombreM, fechaRegistro, RH, descripcion;
//        
//        nombreM = "'"+objM.getNombreM()+"'";
//        fechaRegistro = "'"+objM.getFechaRegistro()+"'";
//        edad = Integer.toString(objM.getEdad());
//        RH = "'"+objM.getRH()+"'";
//        descripcion = "'"+objM.getDescripcion()+"'";
//        idD = Integer.toString(objM.getIdD());
//        idR = Integer.toString(objM.getIdR());
//        
//        
//        
//        String sql = "INSERT INTO entrenador(nombre, fechaRegistro, edad, RH) values("+nombreM+", "+fechaRegistro+", "+edad
//                + ", "+RH+", "+descripcion+", "+idD+","+ idR+")";
//        m = objM.insertaMasota(sql, objCB);
//        return m;
//    }
    
    public static boolean insertarMascota(Mascota objM){
        boolean m; 
        
        String sql = "INSERT INTO mascotas(nombre, fechaRegistro, edad, RH, descripcion, imagen, idD, idR)"+
                "values(?,?,?,?,?,?,?,?)";
        m = objM.insertarMascota(sql);
        
        return m;
    }
    
    public static Mascota obtenerMascota(int idMascota){

        Mascota objM = new Mascota();
        
 
        String nombreM;
        String fechaRegistro;
        int edad; 
        String RH;
        String descripcion;
        String imagen;
        int idD;
        int idR; 
        

        String sql = "SELECT * FROM mascotas WHERE idMascota =" + Integer.toString(idMascota);
        ResultSet rs = objM.obtenerMascota(sql);
        
        if(rs == null){
            objM = null;
        }else{
            try{
                rs.next();
                nombreM = rs.getString("nombre");
                fechaRegistro = rs.getString("fechaRegistro");
                edad = rs.getInt("edad");
                RH = rs.getString("RH");
                imagen = "";                
                descripcion = rs.getString("descripcion");
                
                idD = rs.getInt("idD");
                idR = rs.getInt("idR");
                
                objM = new Mascota(idMascota, nombreM, fechaRegistro, edad, RH, descripcion, imagen, idD, idR);
                
                
                
            }catch(Exception e){
                System.out.println("Error: "+e.toString());
            }
        }
        return objM;
    }
    
    public static boolean eliminarMascota(int idMascota){
        boolean b;
        Mascota objM = new Mascota();
        
        String sql = "DELETE FROM mascotas WHERE idMascota = "+ Integer.toString(idMascota);
        b = objM.eliminarMascota(sql);
        
        return b;
    }
    
    public static boolean actualizarMascota(Mascota objM){
        boolean b;
        
        String nombre, fechaRegistro, RH, descripcion, imagen, edad, idD, idR;
        
        
        nombre = "'"+objM.getNombreM()+"'";
        fechaRegistro = "'"+objM.getFechaRegistro()+"'";
        edad = Integer.toString(objM.getEdad());
        RH = "'"+objM.getRH()+"'";
        descripcion = "'"+objM.getDescripcion()+"'";
        imagen = "'"+objM.getImagen()+"'";
        idD = Integer.toString(objM.getIdD());
        System.out.println(idD);
        idR = Integer.toString(objM.getIdR());
                
        String sql = "UPDATE mascotas SET "
                + "nombre = "+nombre+", fechaRegistro = "+fechaRegistro+", edad = "+edad+", RH = "+RH+", imagen = "+imagen+
                ", descripcion = "+descripcion+", imagen = "+imagen+", idD = "+idD+", idR = "+idR
                + " WHERE idMascota = "+ Integer.toString(objM.getIdMascota());
        
        b = objM.actualizarMascota(sql);
        return b;
    }
    
    }
    