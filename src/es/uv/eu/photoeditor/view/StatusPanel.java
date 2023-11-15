/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Santi
 */
public class StatusPanel extends JPanel{
    PhotoEditorModel modelo;
    LineWidthIndicator lineWidthIndicator;
    LineColorIndicator lineColorIndicator;
    FillColorIndicator fillColorIndicator;

    public StatusPanel(PhotoEditorModel _modelo) {
        // Crear borde gris con espacios en medio de 5 //
        Border insideBorder1 = BorderFactory.createEmptyBorder(5,5,5,5);
        Border insideBorder2 = BorderFactory.createLineBorder(Color.GRAY);
        Border insideBorder = BorderFactory.createCompoundBorder(insideBorder2, insideBorder1);
        
        Border outsideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        this.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        
        modelo = _modelo;
        
        this.setLayout(new GridLayout(1,3));
        
        lineWidthIndicator = new LineWidthIndicator(modelo);
        lineColorIndicator = new LineColorIndicator(modelo);
        fillColorIndicator = new FillColorIndicator(modelo);
        add(lineWidthIndicator);
        add(lineColorIndicator);
        add(fillColorIndicator);
    }
    
    public void updateLineWidth(int n) {
        lineWidthIndicator.update(n);
    }
    
    public void updateLineColor(Color c) {
        lineColorIndicator.update(c);
    }
    
    public void updateFillColor(Color c) {
        fillColorIndicator.update(c);
    }
}
