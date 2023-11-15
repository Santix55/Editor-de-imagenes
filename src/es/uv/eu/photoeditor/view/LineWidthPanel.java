/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.controller.PhotoEditorController;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import static javax.swing.BoxLayout.Y_AXIS;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Santi
 */
public class LineWidthPanel extends JPanel {
    private JSlider slider;
            
    public LineWidthPanel(){
        // Crear borde gris con espacios en medio de 5 //
        Border insideBorder1 = BorderFactory.createEmptyBorder(5,5,5,5);
        Border insideBorder2 = BorderFactory.createLineBorder(Color.GRAY);
        Border insideBorder = BorderFactory.createCompoundBorder(insideBorder2, insideBorder1);
        
        Border outsideBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        this.setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        
        
        this.setLayout(new BoxLayout(this, Y_AXIS));
        
        JLabel label = new JLabel("Grosor Pincel");
        label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(label);
        
        slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(slider);
    }

    void addListener(ChangeListener line_width_listener) {
        slider.addChangeListener(line_width_listener);
    }
}
