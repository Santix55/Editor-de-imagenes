/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Santi
 */
public class SelectPanel extends JPanel {
    private LineWidthPanel line_width_panel;
    private ColorPanel line_color_panel;
    private ColorPanel fill_color_panel;
    
    public SelectPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        line_width_panel = new LineWidthPanel();
        line_color_panel = new ColorPanel("línea");
        fill_color_panel = new ColorPanel("relleno");
        
        line_width_panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        line_color_panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        fill_color_panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        
        add(line_width_panel);
        add(line_color_panel);
        add(fill_color_panel);
    }

    void addListener(PhotoEditorController.FillColorListener fill_color_listener, PhotoEditorController.LineColorListener line_color_listener, PhotoEditorController.LineWidthListener line_width_listener) {
        line_width_panel.addListener(line_width_listener);
        line_color_panel.addListener(line_color_listener);
        fill_color_panel.addListener(fill_color_listener);
    }
}
