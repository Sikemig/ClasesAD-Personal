package org.example.gestorligas.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.gestorligas.dao.JugadorDAO;
import org.example.gestorligas.model.Jugador;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController implements Initializable {

    @FXML
    private Label textDetail;

    @FXML
    private Button btnAnadir;

    @FXML
    private TextField editNombre;

    private JugadorDAO jugadorDAO;

    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        instancias();
        btnAnadir.setOnAction(event ->{
            Jugador jugador = new Jugador(editNombre.getText(), "Española", "10000", 2);
            jugadorDAO.addJugador(jugador);

            // ejecutar metodo añadir --> se necesita una referencia del main controler
            mainController.agregarJugador(jugador);
            ((Stage)(btnAnadir.getScene().getWindow())).close();
        });
    }

    public void setData(MainController controller){
        this.mainController = controller;
    }

    private void instancias() {
        jugadorDAO = new JugadorDAO();
    }
}
