/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import es.uv.eu.photoeditor.model.PhotoEditorModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Santi
 */
public class ImagenPanel extends JPanel{
    PhotoEditorModel modelo; 
    
    ImagenPanel(PhotoEditorModel _modelo) {
        // Crear borde gris con espacios en medio de 5 //
        Border insideBorder1 = BorderFactory.createEmptyBorder(5,5,5,5);
        Border insideBorder2 = BorderFactory.createLineBorder(Color.GRAY);
        Border insideBorder = BorderFactory.createCompoundBorder(insideBorder2, insideBorder1);
        
        Border outsideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        this.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        
        
        modelo = _modelo;
        this.setBackground(Color.LIGHT_GRAY);
    }
        
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        this.setBackground(Color.LIGHT_GRAY);
        
        BufferedImage imagen = modelo.getImagen();
        g2d.drawImage(imagen, 0 , 0, imagen.getWidth(), imagen.getHeight(), this);
   }

    void addListener(PhotoEditorController.RatonListener raton_listener) {
        this.addMouseListener(raton_listener);
    }
}
