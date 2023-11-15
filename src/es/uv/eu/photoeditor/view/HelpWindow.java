/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author usuario
 */
public class HelpWindow extends JFrame {
    JTextArea text_area;
    public HelpWindow() {
        text_area = new JTextArea();
        
        text_area.append("- Click izquierdo sobre la imagen para añadir vertice \n");
        text_area.append("- Click derecho sobre la imagen para añadir nuevo vertice y cerrar la figura \n");
        text_area.append("- Para cambiar el color de relleno o de borde pulsa los colores de la izquierda \n");
        text_area.append("- Desplaza superior izquierda para cambiar el grosor \n");
        text_area.append("- Para cargar una imagen dirigete a Archivo > Cargar y selecciona la ruta \n");
        text_area.append("- Para guardar una imagen dirigite a Archivo > Guardar y selecciona la ruta \n");
        text_area.append("- Para salir pulsa X en la ventana del editor o dirigete a Archivo > Salir \n");
        
        this.add(text_area);
        
        this.setVisible(false);
        this.setTitle("Ayuda");
        this.setSize(300, 300);
    }
}
