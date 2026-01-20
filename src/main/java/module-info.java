module ec.edu.espoch.queuepriority {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espoch.queuepriority to javafx.fxml;
    opens ec.edu.espoch.queuepriority.controller to javafx.fxml;
    exports ec.edu.espoch.queuepriority;
    exports ec.edu.espoch.queuepriority.controller;
    exports ec.edu.espoch.queuepriority.modelo;
    exports ec.edu.espoch.queuepriority.vista;
}
