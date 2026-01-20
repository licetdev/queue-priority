/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.queuepriority.modelo;

/**
 *
 * @author Admin
 */
public class Node {
    
    int dato;
    int prioridad;
    Node siguiente;

    public Node(int dato, int prioridad) {
        this.dato = dato;
        this.prioridad = prioridad;
        this.siguiente = null;
    }

}
