/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.queuepriority.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 *
 * @author Admin
 */
public class QueuePriority {
    private Node frente;

    public boolean isEmpty() {
        return frente == null;
    }

    public void enqueue(int dato, int prioridad) {
        Node nuevo = new Node(dato, prioridad);

        // Si está vacía o tiene mayor prioridad que el frente
        if (frente == null || prioridad < frente.prioridad) {
            nuevo.siguiente = frente;
            frente = nuevo;
            return;
        }

        Node actual = frente;
        while (actual.siguiente != null &&
               actual.siguiente.prioridad <= prioridad) {
            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cola vacía");
        }
        int valor = frente.dato;
        frente = frente.siguiente;
        return valor;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Cola vacía");
        }
        return frente.dato;
    }

    public List<Integer> toList() {
    List<Integer> list = new ArrayList<>();
    Node actual = frente;
    while (actual != null) {
        list.add(actual.dato); // SOLO el dato
        actual = actual.siguiente;
    }
    return list;
}

}
