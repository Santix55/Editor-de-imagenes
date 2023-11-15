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
public class LineColorIndicator extends JPanel {
    private JLabel color;
    private PhotoEditorModel modelo;
    
    public LineColorIndicator(PhotoEditorModel _modelo) {
        modelo = _modelo;
        add(new JLabel("Color del pincel :"));
        
        color = new JLabel("               ");
        color.setBackground(Color.white);
        color.setOpaque(true);
        add(color);
    }

    public void update(Color c) {
        color.setBackground(c);
    }
}
