package org.example.gestorligas.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.gestorligas.LigasApp;
import org.example.gestorligas.dao.JugadorDAO;
import org.example.gestorligas.model.Jugador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<Jugador> tabla;

    @FXML
    private TableColumn columnaNombre, columnaValor, columnaNacionalidad, columnaGoles;
    
    private ObservableList<Jugador> listaJugadores; // tipo de lista que muestra los cambios en vivo

    private JugadorDAO jugadorDAO;

    @FXML
    private Button btnVolver;

    @FXML
    private MenuItem menuSalir, menuBorrar, menuAnadir, menuAutor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        instancias();
        acciones();

    }

    private void acciones() {
        menuBorrar.setOnAction(event -> {
            if(tabla.getSelectionModel().getSelectedIndex() != -1) {
                Jugador jugadorSeleccionado = tabla.getSelectionModel().getSelectedItem();
                int indice = tabla.getSelectionModel().getSelectedIndex();

                listaJugadores.remove(jugadorSeleccionado);
                jugadorDAO.removeJugador(jugadorSeleccionado);

                tabla.getSelectionModel().clearSelection();
            } else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("No hay jugador seleccionado");
                alert.setTitle("Aviso");
                alert.showAndWait();
            }
        });

        btnVolver.setOnAction(event -> {
            Jugador jugador = tabla.getSelectionModel().getSelectedItem();
            System.out.println(jugador.getId());
        });

        menuSalir.setOnAction(event -> {
            System.exit(0);
        });

        menuAutor.setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("El autor de la aplicación soy yo");
            alert.setTitle("Ayuda");
            alert.showAndWait();
        });

        menuAnadir.setOnAction(event ->{
            FXMLLoader loader = new FXMLLoader(LigasApp.class.getResource("detail-view.fxml"));
            try {
                Parent root = loader.load();

                // setData para pasar esta ventana a la otra (como las activity)
                DetailController detailController = loader.getController();
                detailController.setData(this);

                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setScene(scene);
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(btnVolver.getScene().getWindow());
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private void instancias() {
        jugadorDAO = new JugadorDAO();

        listaJugadores = FXCollections.observableArrayList();

        listaJugadores.addAll(jugadorDAO.getAllJugadores());

        tabla.setItems(listaJugadores);

        columnaGoles.setCellValueFactory(new PropertyValueFactory<>("goles"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaNacionalidad.setCellValueFactory(new PropertyValueFactory<>("nacionalidad"));
        columnaValor.setCellValueFactory(new PropertyValueFactory<>("valorMercado"));


        // Atajos de teclados
        menuSalir.setAccelerator(new KeyCodeCombination(KeyCode.Q, KeyCombination.CONTROL_ANY));
        menuAutor.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_ANY));
        menuBorrar.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_ANY));
    }

    public void agregarJugador(Jugador jugador){
        listaJugadores.add(jugador);
    }
}
