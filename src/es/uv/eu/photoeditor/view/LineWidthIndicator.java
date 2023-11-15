/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.view;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author usuario
 */
public class LineWidthIndicator extends JPanel {
    JTextArea text;
    PhotoEditorModel modelo;
    
    public LineWidthIndicator(PhotoEditorModel _modelo) {
        modelo = _modelo;
        add(new JLabel("Grosor de línea :"));
        text = new JTextArea();
        text.setText("1");
        add(text);
    }
    
    public void update(int n) { 
        String str = Integer.toString(n);
        text.setText(str);
    }
}
