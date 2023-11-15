/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Santi
 */
public class PhotoEditorMenuBar extends JMenuBar {

    private JMenu archivo;
    private JMenuItem ayuda;

    private JMenuItem cargar;
    private JMenuItem guardar;
    private JMenuItem salir;

    public PhotoEditorMenuBar() {
        archivo = new JMenu("Archivo");
        this.add(archivo);
        ayuda = new JMenuItem("Ayuda");
        this.add(ayuda);

        cargar = new JMenuItem("Cargar");
        archivo.add(cargar);
        guardar = new JMenuItem("Guardar");
        archivo.add(guardar);
        salir = new JMenuItem("Salir");
        archivo.add(salir);
    }

    void addListener(PhotoEditorController.MenuListener menu_listener) {
        cargar.setActionCommand("cargar");
        guardar.setActionCommand("guardar");
        salir.setActionCommand("salir");
        ayuda.setActionCommand("ayuda");

        cargar.addActionListener(menu_listener);
        guardar.addActionListener(menu_listener);
        salir.addActionListener(menu_listener);
        ayuda.addActionListener(menu_listener);
    }
}
