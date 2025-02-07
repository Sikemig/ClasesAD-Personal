module org.example.gestorligas {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.gestorligas to javafx.fxml;
    exports org.example.gestorligas;
    exports org.example.gestorligas.controller;
    opens org.example.gestorligas.controller to javafx.fxml;
}