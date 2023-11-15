/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import es.uv.eu.photoeditor.model.PhotoEditorModel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


/**
 *
 * @author Santi
 */
public class PhotoEditorView extends JFrame{
    private PhotoEditorModel modelo;
    
    private PhotoEditorMenuBar menu_bar;
    private SelectPanel select_panel;
    private ImagenPanel imagen_panel;
    private StatusPanel status_panel;
    
    public HelpWindow help_window;
    
    public PhotoEditorView(PhotoEditorModel _modelo){
        modelo = _modelo;
        help_window = new HelpWindow();
        
        menu_bar = new PhotoEditorMenuBar();
        select_panel = new SelectPanel();
        imagen_panel = new ImagenPanel(modelo);
        status_panel = new StatusPanel(modelo);
        
        
        add(menu_bar, BorderLayout.NORTH);
        add(select_panel, BorderLayout.WEST);
        add(imagen_panel, BorderLayout.CENTER);
        add(status_panel, BorderLayout.SOUTH);
        
        this.setTitle("Image Viewer");
        this.setSize(1230, 720);
        this.setVisible(true);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addListener(PhotoEditorController.FillColorListener fill_color_listener, PhotoEditorController.LineColorListener line_color_listener, PhotoEditorController.LineWidthListener line_width_listener, PhotoEditorController.MenuListener menu_listener, PhotoEditorController.RatonListener raton_listener) {
        imagen_panel.addListener(raton_listener);
        select_panel.addListener(fill_color_listener, line_color_listener, line_width_listener);
        menu_bar.addListener(menu_listener);
    }
    
    public void updateLineWidth(int n) {
        status_panel.updateLineWidth(n);
    }
    
    public void updateLineColor(Color c) {
        status_panel.updateLineColor(c);
    }
    
    public void updateFillColor(Color c) {
        status_panel.updateFillColor(c);
    }
    
    public void updateImagen() {
        imagen_panel.repaint();
    }
}
