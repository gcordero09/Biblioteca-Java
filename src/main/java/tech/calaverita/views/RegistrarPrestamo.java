/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tech.calaverita.views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.calaverita.idao.PrestamoDaoJdbc;
import tech.calaverita.models.Libro;
import tech.calaverita.models.Prestamo;

/**
 *
 * @author memoc
 */
public class RegistrarPrestamo extends javax.swing.JPanel {

    /**
     * Creates new form Prestamos
     */
    PrestamoDaoJdbc prestamoDaoJdbc;
    Prestamo prestamo;

    public RegistrarPrestamo() {
        initComponents();
        prestamoDaoJdbc = new PrestamoDaoJdbc();
        Subida.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        libroId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        usuarioId = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Subida = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        libroId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        libroId.setForeground(new java.awt.Color(204, 204, 204));
        libroId.setText("Ingrese el id del libro");
        libroId.setBorder(null);
        add(libroId, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 180, 10));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Prestar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 180, 60));

        usuarioId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        usuarioId.setForeground(new java.awt.Color(204, 204, 204));
        usuarioId.setText("Ingrese el id del usuario");
        usuarioId.setBorder(null);
        add(usuarioId, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jSeparator2.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 180, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prestamo.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-230, -130, 630, 590));

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel2.setText("Usuario");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        Subida.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Subida.setText("??Prestamo exitoso!");
        add(Subida, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 130, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel3.setText("Libro");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int usuarioId = Integer.parseInt(this.usuarioId.getText());
            int libroId = Integer.parseInt(this.libroId.getText());

            prestamo = new Prestamo("", "", false, usuarioId, libroId);
            prestamoDaoJdbc.insertar(prestamo);
            Subida.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Subida;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField libroId;
    private javax.swing.JTextField usuarioId;
    // End of variables declaration//GEN-END:variables
}
