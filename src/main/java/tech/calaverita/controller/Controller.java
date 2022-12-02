package tech.calaverita.controller;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import tech.calaverita.views.Biblioteca;
import tech.calaverita.views.Prestamos;

public class Controller {

    Biblioteca biblioteca;

    public Controller(Biblioteca index) {
        biblioteca = index;
    }

    public void setVista(JPanel vista) {
        final SwingWorker worker = new SwingWorker() {
            @Override
            protected Object doInBackground() throws Exception {
                vista.setSize(600, 400);
                vista.setLocation(0, 0);

                biblioteca.getContenido().removeAll();
                biblioteca.getContenido().add(vista, BorderLayout.CENTER);
                biblioteca.getContenido().revalidate();
                biblioteca.getContenido().repaint();
                return null;
            }
        };
        worker.execute();
    }

    public void setCabecera(String texto) {
        this.biblioteca.getCabecera().setText(texto);
    }

}
