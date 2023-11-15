/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Santi
 */
public class ColorPanel extends JPanel{
    JButton c1;
    JButton c2;
    JButton c3;
    JButton c4;
    JButton c5;
    JButton c6;
    JButton c7;
    JButton c8;
    JButton c9;
    JButton c10;
    JButton c11;
    JButton c12;
    JButton c13;
    
    public ColorPanel(String str) {
        // Crear borde gris con espacios en medio de 5 //
        Border insideBorder1 = BorderFactory.createEmptyBorder(5,5,5,5);
        Border insideBorder2 = BorderFactory.createLineBorder(Color.GRAY);
        Border insideBorder = BorderFactory.createCompoundBorder(insideBorder2, insideBorder1);
        
        Border outsideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        this.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        
        
        this.setLayout(new GridLayout(7,2,10,10));
        
        add(new JLabel("Color de "+str+":"));
        
        c1 = new JButton("Negro");          c1.setBackground(Color.BLACK);      add(c1);    c1.setForeground(Color.WHITE);
        c2 = new JButton("Cyan");           c2.setBackground(Color.CYAN);       add(c2);
        c3 = new JButton("Gris Ocscuro");   c3.setBackground(Color.DARK_GRAY);  add(c3);    c3.setForeground(Color.WHITE);
        c4 = new JButton("Gris");           c4.setBackground(Color.GRAY);       add(c4);
        c5 = new JButton("Gris Claro");     c5.setBackground(Color.LIGHT_GRAY); add(c5);
        c6 = new JButton("Magenta");        c6.setBackground(Color.MAGENTA);    add(c6);
        c7 = new JButton("Naranja");        c7.setBackground(Color.ORANGE);     add(c7);
        c8 = new JButton("Rosa");           c8.setBackground(Color.PINK);       add(c8);
        c9 = new JButton("Amarillo");       c9.setBackground(Color.YELLOW);     add(c9);
        c10 = new JButton("Blanco");        c10.setBackground(Color.WHITE);     add(c10);
        c11 = new JButton("Rojo");          c11.setBackground(Color.RED);       add(c11);
        c12 = new JButton("Azul");          c12.setBackground(Color.BLUE);      add(c12);   c12.setForeground(Color.WHITE);
        c13 = new JButton("Verde");         c13.setBackground(Color.GREEN);     add(c13);
    }

    void addListener(PhotoEditorController.LineColorListener color_listener) {
        c1.addActionListener(color_listener);
        c2.addActionListener(color_listener);
        c3.addActionListener(color_listener);
        c4.addActionListener(color_listener);
        c5.addActionListener(color_listener);
        c6.addActionListener(color_listener);
        c7.addActionListener(color_listener);
        c8.addActionListener(color_listener);
        c9.addActionListener(color_listener);
        c10.addActionListener(color_listener);
        c11.addActionListener(color_listener);
        c12.addActionListener(color_listener);
        c13.addActionListener(color_listener);
    }

    void addListener(PhotoEditorController.FillColorListener color_listener) {
        c1.addActionListener(color_listener);
        c2.addActionListener(color_listener);
        c3.addActionListener(color_listener);
        c4.addActionListener(color_listener);
        c5.addActionListener(color_listener);
        c6.addActionListener(color_listener);
        c7.addActionListener(color_listener);
        c8.addActionListener(color_listener);
        c9.addActionListener(color_listener);
        c10.addActionListener(color_listener);
        c11.addActionListener(color_listener);
        c12.addActionListener(color_listener);
        c13.addActionListener(color_listener);
    }
}
