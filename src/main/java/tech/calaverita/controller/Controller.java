package tech.calaverita.controller;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tech.calaverita.views.Biblioteca;

public class Controller {

    Biblioteca biblioteca;

    public Controller(Biblioteca index) {
        biblioteca = index;
    }

    public void setVista(JPanel vista) {
        vista.setSize(600, 400);
        vista.setLocation(0, 0);

        this.biblioteca.getContenido().removeAll();
        this.biblioteca.getContenido().add(vista, BorderLayout.CENTER);
        this.biblioteca.getContenido().revalidate();
        this.biblioteca.getContenido().repaint();
    }
    
    public void setCabecera(String texto){
        this.biblioteca.getCabecera().setText(texto);
    }

}
