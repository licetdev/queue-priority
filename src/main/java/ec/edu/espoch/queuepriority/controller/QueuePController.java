/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.queuepriority.controller;

import ec.edu.espoch.queuepriority.modelo.QueuePriority;
import ec.edu.espoch.queuepriority.vista.QueueCanvas;
import java.util.NoSuchElementException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Admin
 */
public class QueuePController {

    @FXML
    private TextField txtValue;

    @FXML
    private TextField txtPriority;

    @FXML
    private StackPane canvasHolder;

    private QueueCanvas canvas;
    private final QueuePriority queue = new QueuePriority();

    @FXML
    private void initialize() {
        canvas = new QueueCanvas();
        canvasHolder.getChildren().add(canvas);
    }

    @FXML
    private void enqueue() {
        Integer value = readInt(txtValue);
        Integer priority = readInt(txtPriority);

        if (value == null || priority == null) {
            return;
        }

        queue.enqueue(value, priority);
        toList();
    }

    @FXML
    private void dequeue() {
        try {
            queue.dequeue();
            toList();
        } catch (NoSuchElementException e) {
            System.out.println("La cola está vacía, no se puede eliminar");
            // aquí podrías mostrar un Alert si quieres
        }
    }

    private Integer readInt(TextField tf) {
        try {
            return Integer.valueOf(tf.getText().trim());
        } catch (Exception e) {
            return null;
        }
    }

    @FXML
    private void peek() {
        try {
            int value = queue.peek();
            System.out.println("Elemento con mayor prioridad: " + value);

            // Opcional: resaltar en el canvas
            canvas.highlightFront();
            canvas.render();

        } catch (NoSuchElementException e) {
            System.out.println("La cola está vacía");
        }
    }

    @FXML
    private void toList() {
        canvas.setValues(queue.toList());
        canvas.render();
    }

}
