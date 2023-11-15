/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uv.eu.photoeditor.controller;

import es.uv.eu.photoeditor.model.PhotoEditorModel;
import es.uv.eu.photoeditor.view.PhotoEditorView;
import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author usuario
 */
public class PhotoEditorController {
    PhotoEditorModel modelo;
    PhotoEditorView vista;
    
   private  FillColorListener fill_color_listener;
    LineColorListener line_color_listener;
    LineWidthListener line_width_listener;
    MenuListener menu_listener;
    RatonListener raton_listener;
    
   private Polygon poligono;
   private int grosor;
   private Color relleno, pincel;
    
    
    public PhotoEditorController(PhotoEditorModel _modelo, PhotoEditorView _vista) {
        modelo = _modelo;
        vista = _vista;
        
        fill_color_listener = new FillColorListener();
        line_color_listener = new LineColorListener();
        line_width_listener = new LineWidthListener();
        menu_listener = new MenuListener();
        raton_listener = new RatonListener();
        
        vista.addListener(fill_color_listener, line_color_listener, line_width_listener, menu_listener, raton_listener);
        
        poligono = new Polygon();
        grosor = 1;
        relleno = Color.WHITE;
        pincel = Color.WHITE;
    }
    
    public class FillColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            System.out.println("relleno : " + boton.getText());
            relleno = boton.getBackground();
            vista.updateFillColor(relleno);
        }
    }
    
    public class LineColorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            System.out.println("relleno : " + boton.getText());
            pincel = boton.getBackground();
            vista.updateLineColor(pincel);
        }
    }
    
    public class LineWidthListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider)e.getSource();
            grosor = slider.getValue();
            System.out.println("grosor = "+grosor);
            vista.updateLineWidth(grosor);
        }
    }

    public class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            System.out.println(cmd);
            if(cmd.equals( "salir")) {
                System.exit(0);
            }
            else if(cmd.equals("cargar")){
                JFileChooser file_chooser = new JFileChooser();
                int seleccion = file_chooser.showOpenDialog(file_chooser);
                if( seleccion == JFileChooser.APPROVE_OPTION ) {
                    File fichero = file_chooser.getSelectedFile();
                    modelo.loadImagen(fichero);
                    vista.updateImagen();
                }
            }
            else if(cmd.equals("guardar")) {
                JFileChooser file_chooser = new JFileChooser ();
                int seleccion = file_chooser.showSaveDialog(file_chooser);
                if( seleccion == JFileChooser.APPROVE_OPTION ) {
                    File fichero = file_chooser.getSelectedFile();
                    modelo.saveImagen(fichero);
                }
            }
            else if(cmd.equals("ayuda")) {
                vista.help_window.setVisible(true);
            }
            else {
                System.out.println("comando desconocido");
            }
        }
    }

    public class RatonListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton()== MouseEvent.BUTTON1)  // click izquierdo
            {
                int x = e.getX();
                int y = e.getY();
                
                System.out.println("Click Izquierdo en ("+x+","+y+")");
                poligono.addPoint(x, y);
            }
            else if(e.getButton() == MouseEvent.BUTTON3) // click derecho
            {
                int x = e.getX();
                int y = e.getY();
                
                System.out.println("Click Dererecho en ("+x+","+y+")");
                poligono.addPoint(x, y);
                modelo.pintaPoligono(poligono, grosor, pincel, relleno);
                poligono.reset();
               // vista.updateImagen();
               vista.repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
