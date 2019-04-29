/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import control.ControlDuenio;
import control.ControlEntrenador;
import control.ControlEntrenamientos;
import control.ControlMascota;
import control.ControlRaza;
import control.ControlVeterinario;
import control.Controlcita;
import control.Controltelefono_duenio;
import control.Controltelefono_entrenador;
import control.Controltelfono_veterinario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Duenio;
import modelo.Entrenador;
import modelo.Entrenamientos;
import modelo.Mascota;
import modelo.Raza;
import modelo.Veterinario;
import modelo.telefono_duenio;
import modelo.telefono_entrenador;
import modelo.telfono_veterinario;

/**
 * FXML Controller class
 *
 * @author david
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //ingresarMascota
    @FXML
    AnchorPane IM, ID, IV, IR, IETO, ITD, ITV, ITE, IE, EM, ED, EV, EETO, ER, ETD, ETV, ETE, EC, EE;
    //mascota
    @FXML
    TextField TFnombre, TFfecha, TFedad, TFrh, TFimagen, TFdescripcion, TFidd, TFidr;
    //Dueño
    @FXML
    TextField nombre1, nombre2, apellido1, apellido2, direccion, correo;
    //insertar Raza
    @FXML
    TextField insertarR;
    //veterinario
    @FXML
    TextField nombre1v, nombre2v, apellido1v, apellido2v, especialidad;
    //Entrenamiento
    @FXML
    TextField nombreETO, valorETO, duracionETO;
    //Telefono dueño
    @FXML
    TextField idDuenioT, numero;
    //telefono vaterinario
    @FXML
    TextField idVeteT, numero1;
    //telefono entrenador
    @FXML
    TextField idEntreT, numero11;
    //Entrenador
    @FXML
    TextField nombre1E, nombre2E, apellido1E, apellido2E, horarioI, horarioF;
    //Eliminar Masccotas
    @FXML
    TextField idmasco;
    //Eliminar Dueño
    @FXML
    TextField idduenio;
    //Eliminar Veterinaio
    @FXML
    TextField idveterinario;
    //Eliminar Entrenamiento
    @FXML
    TextField identrenamiento;
    //eliminar raza
    @FXML
    TextField idraza;
    //eliminar telefono dueño
    @FXML
    TextField idtelefonoduenio;
    //ELIMINAR TELEFONO VETERINARIO
    @FXML
    TextField idtelefonoveterinario;
    //eliminar telefono entrenador
    @FXML
    TextField idtelefonoentrenador;
    //eliminar cita
    @FXML
    TextField idcita;
    //eliminar entrenador
    @FXML
    TextField identrenador;

    @FXML
    public void ingresarMascota(ActionEvent event) {

        IM.setVisible(true);
        ID.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        IETO.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        ETV.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        ETE.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void insertMascota(ActionEvent event) {
        String nombre, fecha, RH, Imagen, descripcion;
        int edad, idD, idR;

        nombre = TFnombre.getText();
        fecha = TFfecha.getText();
        RH = TFrh.getText();
        Imagen = TFimagen.getText();
        descripcion = TFdescripcion.getText();
        edad = Integer.parseInt(TFedad.getText());
        idD = Integer.parseInt(TFidd.getText());
        idR = Integer.parseInt(TFidr.getText());

        Mascota objM = new Mascota(nombre, fecha, edad, RH, descripcion, Imagen, idD, idR);
        boolean b = ControlMascota.insertarMascota(objM);

        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }

        TFnombre.clear();
        TFfecha.clear();
        TFrh.clear();
        TFimagen.clear();
        TFdescripcion.clear();
        TFedad.clear();
        TFidd.clear();
        TFidr.clear();

    }

    @FXML
    public void insertarRaza(ActionEvent event) {
        String nombreR = insertarR.getText();
        Raza r = new Raza(nombreR);
        boolean b = ControlRaza.insertarRaza(r);
        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }

        insertarR.clear();
    }

    @FXML
    public void ingresarRaza(ActionEvent event) {
        IV.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IR.setVisible(true);
        ETV.setVisible(false);
        ETE.setVisible(false);
        IETO.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);

    }

    @FXML
    public void ingresarVeterinario(ActionEvent event) {
        IV.setVisible(true);
        ID.setVisible(false);
        IM.setVisible(false);
        IR.setVisible(false);
        IETO.setVisible(false);
        ITD.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITV.setVisible(false);
        ETV.setVisible(false);
        ETE.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void insertarVeterinario(ActionEvent event) {
        String nombrev1, nombrev2, apellidov1, apellidov2, especialidadv;

        nombrev1 = nombre1v.getText();
        nombrev2 = nombre2v.getText();
        if (nombrev2.equals("")) {
            nombrev2 = "default";
        }
        apellidov1 = apellido1v.getText();
        apellidov2 = apellido2v.getText();
        if (apellidov2.equals("")) {
            apellidov2 = "default";
        }
        especialidadv = especialidad.getText();

        Veterinario objV = new Veterinario(nombrev1, nombrev2, apellidov1, apellidov2, especialidadv);
        boolean v = ControlVeterinario.insertarVeterinario(objV);
        if (v) {
            JOptionPane.showMessageDialog(null, "Se ha ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha ingresado los datos", "Operacion Fallida", JOptionPane.INFORMATION_MESSAGE);
        }
        nombre1v.clear();
        nombre2v.clear();
        apellido1v.clear();
        apellido2v.clear();
        especialidad.clear();

    }

    @FXML
    public void ingresarDuenio(ActionEvent event) {

        ID.setVisible(true);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        IETO.setVisible(false);
        ETV.setVisible(false);
        ETE.setVisible(false);
        ITD.setVisible(false);
        ITE.setVisible(false);
        ITV.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void insertarDuenio(ActionEvent event) {
        String nombre1d = nombre1.getText();
        String nombre2d = nombre2.getText();
        if (nombre2d.equals("")) {
            nombre2d = "default";
        }
        String apellido1d = apellido1.getText();
        String apellido2d = apellido2.getText();
        if (apellido2d.equals("")) {
            apellido2d = "default";
        }
        String direcciond = direccion.getText();
        String correod = correo.getText();

        Duenio objD = new Duenio(nombre1d, nombre2d, apellido1d, apellido2d, direcciond, correod);
        boolean b = ControlDuenio.insertarDuenio(objD);
        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
        nombre1.clear();
        nombre2.clear();
        apellido1.clear();
        apellido2.clear();
        direccion.clear();
        correo.clear();

    }

    @FXML
    public void ingresarEntrenamiento(ActionEvent event) {
        IETO.setVisible(true);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ETE.setVisible(false);
        ITV.setVisible(false);
        ETV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void insertarEntrenamiento(ActionEvent event) {
        String nombre = nombreETO.getText();
        int valor = Integer.parseInt(valorETO.getText());
        int duracion = Integer.parseInt(duracionETO.getText());

        Entrenamientos objE = new Entrenamientos(nombre, valor, duracion);
        boolean b = ControlEntrenamientos.insertarEntrenamiento(objE);

        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void insertarTelefonoDuenio(ActionEvent event) {

        String numerot = numero.getText();
        int idt = Integer.parseInt(idDuenioT.getText());
        telefono_duenio td = new telefono_duenio(numerot, idt);
        boolean b = Controltelefono_duenio.insertarTele_Duenio(td);
        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void ingresarTelefonoDuenio(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ETV.setVisible(false);
        ITD.setVisible(true);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        ETE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void insertarTelefonoVeterianio(ActionEvent event) {
        String numerov = numero1.getText();
        int idVete = Integer.parseInt(idVeteT.getText());
        telfono_veterinario tv = new telfono_veterinario(numerov, idVete);
        boolean b = Controltelfono_veterinario.insertTelVE(tv);
        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void ingresarVeteT(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ETV.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(true);
        ETE.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void ingresarTelefonoEntrenador(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ETV.setVisible(false);
        ETE.setVisible(false);
        ITE.setVisible(true);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void insertarTelefonoEntrenador(ActionEvent event) {
        String numeroE = idEntreT.getText();
        int idE = Integer.parseInt(numero11.getText());
        telefono_entrenador te = new telefono_entrenador(numeroE, idE);
        boolean b = Controltelefono_entrenador.insertarTE(te);
        if (b) {
            JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void insertarEntrenador(ActionEvent event) {
        try {
            String nombre1 = nombre1E.getText();
            String nombre2 = nombre2E.getText();
            if (nombre2.equals("")) {
                nombre2 = "default";
            }
            String apellido1 = apellido1E.getText();
            String apellido2 = apellido2E.getText();
            if (apellido2.equals("")) {
                apellido2 = "default";
            }
            String horarioi = horarioI.getText();
            String horariof = horarioF.getText();

            Entrenador objD = new Entrenador(nombre1, nombre2, apellido1, apellido2, horarioi, horariof);
            boolean b = ControlEntrenador.insertarEntrenador(objD);
            if (b) {
                JOptionPane.showMessageDialog(null, "Se han ingresado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "No se han podido ingresar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @FXML
    public void ingresarEntrenador(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        ETV.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ETE.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(true);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
    }

    @FXML
    public void eliminarMascota(ActionEvent event) {
        int id = Integer.parseInt(idmasco.getText());
        boolean b = ControlMascota.eliminarMascota(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarMascota(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITV.setVisible(false);
        ETE.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        ETV.setVisible(false);
        EM.setVisible(true);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);

    }

    @FXML
    public void eliminarDuenio(ActionEvent event) {
        int idDuenio = Integer.parseInt(idduenio.getText());
        boolean b = ControlDuenio.eliminarDuenio(idDuenio);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarDuenio(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ETE.setVisible(false);
        ED.setVisible(true);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(false);

    }

    @FXML
    public void eliminarVeterinario(ActionEvent event) {
        int id = Integer.parseInt(idveterinario.getText());
        boolean b = ControlVeterinario.eliminarVeterinario(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarVeterinario(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        ETE.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(true);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(false);

    }

    @FXML
    public void eliminarEntrenamiento(ActionEvent event) {
        int id = Integer.parseInt(idveterinario.getText());
        boolean b = ControlEntrenamientos.EliminarEntrenamiento(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void EliminarEntrenamiento(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITV.setVisible(false);
        ETE.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(true);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(false);

    }

    @FXML
    public void eliminarRaza(ActionEvent event) {
        int id = Integer.parseInt(idraza.getText());
        boolean b = ControlRaza.eliminarRaza(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarRaza(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITV.setVisible(false);
        ETE.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(true);
        ETD.setVisible(false);
        ETV.setVisible(false);

    }

    @FXML
    public void eliminarTelefonoDuenio(ActionEvent event) {
        int id = Integer.parseInt(idtelefonoduenio.getText());
        boolean b = Controltelefono_duenio.eliminarTele_Duenio(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarTelefonoDuenio(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        ETE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(true);
        ETV.setVisible(false);
    }

    @FXML
    public void eliminarTelefonoVeterinario(ActionEvent event) {
        int id = Integer.parseInt(idtelefonoveterinario.getText());
        boolean b = Controltelfono_veterinario.eliminarTelVe(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarTelefonoVeterinario(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(true);
        ETE.setVisible(false);

    }

    @FXML
    public void eliminarTelefonoEntrenador(ActionEvent event) {
        int id = Integer.parseInt(idtelefonoentrenador.getText());
        boolean b = Controltelefono_entrenador.eliminarTE(id);
        if (b) {
            JOptionPane.showMessageDialog(null, "Eliminacion exitosa", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminar", "", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    public void EliminarTelefonoEntrenador(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(false);
        ETE.setVisible(true);
        EC.setVisible(false);
        EE.setVisible(false);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void eliminarCita(ActionEvent event) {

        int id = Integer.parseInt(idcita.getText());
        boolean b = Controlcita.eliminarCita(id);

        if (b) {
            JOptionPane.showMessageDialog(null, "Se han eliminado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido eliminar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void eliminarEntrenador(ActionEvent event) {

        int id = Integer.parseInt(identrenador.getText());
        boolean b = ControlEntrenador.eliminarEntrenador(id);

        if (b) {
            JOptionPane.showMessageDialog(null, "Se han eliminado los datos", "Operacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se han podido eliminar los datos", "Operacion Fallida", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void EliminarCita(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(false);
        ETE.setVisible(false);
        EC.setVisible(true);
        EE.setVisible(false);
    }

    @FXML
    public void EliminarEntrenador(ActionEvent event) {
        IETO.setVisible(false);
        ID.setVisible(false);
        IM.setVisible(false);
        IV.setVisible(false);
        IR.setVisible(false);
        ITD.setVisible(false);
        ITV.setVisible(false);
        ITE.setVisible(false);
        IE.setVisible(false);
        EM.setVisible(false);
        ED.setVisible(false);
        EV.setVisible(false);
        EETO.setVisible(false);
        ER.setVisible(false);
        ETD.setVisible(false);
        ETV.setVisible(false);
        ETE.setVisible(false);
        EC.setVisible(false);
        EE.setVisible(true);
    }
}
