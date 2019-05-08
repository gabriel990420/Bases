/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.ConnectBD;
import java.awt.Event;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 *
 * @author david
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField nameTF;
    @FXML
    private PasswordField pssTF;

    String nombre, contraseña;

    @FXML
    private void ingresar(ActionEvent event) {
        nombre = nameTF.getText();
        contraseña = pssTF.getText();

        ConnectBD.setUser(nombre);
        ConnectBD.setPassword(contraseña);

        ConnectBD objCB = new ConnectBD();

        if (objCB.crearConexion()) {
            //cambiar de interfaz
            System.out.println("Conexion creada");

            try {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("principal.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.show();
                objCB.getConexion().close();

            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
    }

    @FXML
    private void ingresarEnter(KeyEvent key) {
        if (key.getCode().equals(KeyCode.ENTER)) {
            
            nombre = nameTF.getText();
            contraseña = pssTF.getText();

            ConnectBD.setUser(nombre);
            ConnectBD.setPassword(contraseña);

            ConnectBD objCB = new ConnectBD();

            if (objCB.crearConexion()) {
                //cambiar de interfaz
                System.out.println("Conexion creada");

                try {
                    ((Node) (key.getSource())).getScene().getWindow().hide();
                    Parent parent = FXMLLoader.load(getClass().getResource("principal.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(parent);
                    stage.setScene(scene);
                    stage.show();
                    objCB.getConexion().close();

                } catch (Exception e) {
                    System.out.println("Error: " + e.toString());
                }
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
