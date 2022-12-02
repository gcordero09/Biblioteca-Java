/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package tech.calaverita.views;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tech.calaverita.idao.UsuarioDaoJdbc;
import tech.calaverita.models.Usuario;

/**
 *
 * @author memoc
 */
public class ModificarUsuario extends javax.swing.JPanel {

    /**
     * Creates new form AddLibro
     */
    UsuarioDaoJdbc usuarioDaoJdbc;
    Usuario usuario;

    public ModificarUsuario() {
        initComponents();
        usuarioDaoJdbc = new UsuarioDaoJdbc();
        Modificado.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Modificado = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        programa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fechaDeNacimiento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Modificado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Modificado.setText("¡Se ha modificado el usuario con éxito!");
        add(Modificado, new org.netbeans.lib.awtextra.AbsoluteConstraints(165, 20, -1, -1));

        correo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        correo.setForeground(new java.awt.Color(204, 204, 204));
        correo.setText("Ingrese el correo del usuario");
        correo.setBorder(null);
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 270, -1));

        programa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        programa.setForeground(new java.awt.Color(204, 204, 204));
        programa.setText("Ingrese el programa");
        programa.setBorder(null);
        add(programa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 270, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel3.setText("Programa");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        nombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombre.setForeground(new java.awt.Color(204, 204, 204));
        nombre.setText("Ingrese el nombre del usuario");
        nombre.setBorder(null);
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 270, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel4.setText("Correo");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel5.setText("Nombre");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        fechaDeNacimiento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fechaDeNacimiento.setForeground(new java.awt.Color(204, 204, 204));
        fechaDeNacimiento.setText("Ingrese la fecha de nacimiento");
        fechaDeNacimiento.setBorder(null);
        add(fechaDeNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 270, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel6.setText("Password");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 90, -1));

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(204, 204, 204));
        password.setText("Ingrese la contraseña del usuario");
        password.setBorder(null);
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 270, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel7.setText("Fecha de nacimiento");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 270, 20));

        jSeparator2.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 270, 20));

        jSeparator3.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 270, 20));

        jSeparator4.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 270, 20));

        jSeparator6.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 270, 20));

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 120, 60));

        id.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        id.setForeground(new java.awt.Color(204, 204, 204));
        id.setText("Ingrese el id nombre del usuario");
        id.setBorder(null);
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 270, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel8.setText("Id");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(51, 102, 255));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 270, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int id = Integer.parseInt(this.id.getText());
            String nombre = this.nombre.getText();
            String programa = this.programa.getText();
            String fechaDeNacimiento = this.fechaDeNacimiento.getText();
            String correo = this.correo.getText();
            String password = this.password.getText();

            usuario = new Usuario(id, nombre, programa, fechaDeNacimiento, correo, password);
            usuarioDaoJdbc.actualizar(usuario);
            Modificado.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Modificado;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField fechaDeNacimiento;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField password;
    private javax.swing.JTextField programa;
    // End of variables declaration//GEN-END:variables
}