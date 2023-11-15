/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author usuario
 */
public class FillColorIndicator extends JPanel {
    private JLabel color;
    //private JPanel color;
    PhotoEditorModel modelo;
    
    public FillColorIndicator(PhotoEditorModel _modelo) {
        modelo = _modelo;
        add(new JLabel("Color de relleno : "));
        
        /*
        color = new JPanel();
        color.setBackground(Color.WHITE);
        color.setSize(90, 20);
        add(color);
        */
        
        color = new JLabel("               ");
        color.setBackground(Color.white);
        color.setOpaque(true);
        add(color);
    }
    
    public void update(Color c) {
        color.setBackground(c);
    }
}
