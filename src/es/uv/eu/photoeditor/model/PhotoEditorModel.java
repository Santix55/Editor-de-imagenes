package es.uv.eu.photoeditor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author diaz
 */
public class PhotoEditorModel {
    private BufferedImage imagen;
    private String imagenFileName = "";

    public PhotoEditorModel() {
        try {
            imagenFileName = "imagenes/imagen_00.jpg";
            imagen = ImageIO.read(new File(imagenFileName));
        }
        catch (IOException e) {
            System.out.println("Problemas leyendo la imagen '" + this.imagenFileName + "'.");
            System.out.println("Motivo: " + e.getLocalizedMessage());
        }
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public String getImagenFileName() {
        return imagenFileName;
    }

    public void loadImagen(File imagenFile) {
        if (imagenFile != null) {
            this.imagenFileName = imagenFile.getName();
            try {
                imagen = ImageIO.read(imagenFile);
            }
            catch (IOException e) {
                System.out.println("Problemas leyendo la imagen '" + this.imagenFileName + "'.");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            }
        }
    }

    public void saveImagen(File imagenFile) {
        if (imagenFile != null) {
            try {
                this.imagenFileName = imagenFile.getName();
                ImageIO.write(imagen,"jpg",imagenFile);
            } 
            catch (IOException e) {
                System.out.println("Problemas guardando la imagen '" + imagenFile.getName() + "'.");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            }
        }
    }
    
    public void pintaPoligono(Polygon poly, int penWidth, Color penColor, Color fillColor) {
        Graphics2D gr = (Graphics2D)imagen.getGraphics();
        gr.setColor(fillColor);
        gr.fillPolygon(poly);
        gr.setColor(penColor);
        gr.setStroke(new BasicStroke(penWidth));
        gr.drawPolygon(poly);
    }
}


/*
package es.uv.eu.photoeditor.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;


public class PhotoEditorModel {
    // Atributos del profesor //
    private BufferedImage imagen;
    private String imagenFileName = "";
    
    // Atributos nuevos //
    private Color color_linea;
    private Color color_relleno;
    private int grosor_linea;
    Polygon poligono;
    

    
    /////////////////////// CONSTRUCTOR ///////////////////////////////////////
    
    public PhotoEditorModel() {
        // NUEVO //
        color_linea = Color.WHITE;
        color_relleno =  Color.WHITE;
        grosor_linea = 1;
        poligono = new Polygon();
        
        // PROFESOR //
        try {
            imagenFileName = "imagenes/imagen_00.jpg";
            imagen = ImageIO.read(new File(imagenFileName));
        }
        catch (IOException e) {
            System.out.println("Problemas leyendo la imagen '" + this.imagenFileName + "'.");
            System.out.println("Motivo: " + e.getLocalizedMessage());
        }
    }
    
    ///////////////////// PROFESOR ////////////////////////////////////////////

    public BufferedImage getImagen() {
        return imagen;
    }

    public String getImagenFileName() {
        return imagenFileName;
    }

    public void loadImagen(File imagenFile) {
        if (imagenFile != null) {
            this.imagenFileName = imagenFile.getName();
            try {
                imagen = ImageIO.read(imagenFile);
            }
            catch (IOException e) {
                System.out.println("Problemas leyendo la imagen '" + this.imagenFileName + "'.");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            }
        }
    }

    public void saveImagen(File imagenFile) {
        if (imagenFile != null) {
            try {
                this.imagenFileName = imagenFile.getName();
                ImageIO.write(imagen,"jpg",imagenFile);
            } 
            catch (IOException e) {
                System.out.println("Problemas guardando la imagen '" + imagenFile.getName() + "'.");
                System.out.println("Motivo: " + e.getLocalizedMessage());
            }
        }
    }
    
    public void pintaPoligono(Polygon poly, int penWidth, Color penColor, Color fillColor) {
        Graphics2D gr = (Graphics2D)imagen.getGraphics();
        gr.setColor(fillColor);
        gr.fillPolygon(poly);
        gr.setColor(penColor);
        gr.setStroke(new BasicStroke(penWidth));
        gr.drawPolygon(poly);
    }
    
    ////////////////// NUEVO //////////////////////////////////////////////////
    public String getGrosorLinea() {
        return String.valueOf(grosor_linea);
    }

    public Color getLineColor() {
        return color_linea;
    }
    
    public Color getFillColor() {
        return color_relleno;
    }

    public void setFillColor(Color background) {
        color_relleno = background;
    }

    public void setLineColor(Color background) {
        color_linea = background;
    }
    
    public void setGrosor(int grosor) {
        grosor_linea = grosor;
    }

    public void cargar() {
        JFileChooser file_chooser = new JFileChooser();
        int seleccion = file_chooser.showOpenDialog(file_chooser);
        if(seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = file_chooser.getSelectedFile();
            this.loadImagen(fichero);
        }
    }

    public void guardar() {
        JFileChooser file_chooser = new JFileChooser();
        int seleccion = file_chooser.showSaveDialog(file_chooser);
        if(seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = file_chooser.getSelectedFile();
            this.saveImagen(fichero);
        }
    }

    public void anyadirPunto(int x, int y) {
        poligono.addPoint(x, y);
    }

    public void cerrarPoligono(int x, int y) {
        poligono.addPoint(x, y);
        poligono.reset();
    }
}
*/