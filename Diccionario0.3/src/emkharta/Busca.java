package emkharta;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Busca {
    public void saludar(ActionEvent actionEvent) {
        String n= elsaludo.getText();
        if (n.length() == 0) {
            System.out.println("No hay naa!");
        }
        else {
            System.out.println("la definicion de, " + n + "es:"+ + );
        }
    }
}