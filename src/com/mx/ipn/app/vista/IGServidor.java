package com.mx.ipn.app.vista;

import com.mx.ipn.app.controlador.HiloServidor;

public class IGServidor extends javax.swing.JFrame {

    private HiloServidor hiloServidor;
    
    public IGServidor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelInicio = new javax.swing.JPanel();
        imagenServidor = new javax.swing.JLabel();
        etiquetaEstado = new javax.swing.JLabel();
        botonIniciar = new javax.swing.JButton();
        botonParar = new javax.swing.JButton();
        etiquetaPuerto = new javax.swing.JLabel();
        textoPuerto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaNotificacion = new javax.swing.JTextArea();
        imagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        etiquetaEstado.setText("Iniciar el servidor");

        botonIniciar.setText("Iniciar");
        botonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIniciarActionPerformed(evt);
            }
        });

        botonParar.setText("Parar");
        botonParar.setEnabled(false);
        botonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPararActionPerformed(evt);
            }
        });

        etiquetaPuerto.setText("Puerto");

        textoPuerto.setText("3030");

        areaNotificacion.setColumns(20);
        areaNotificacion.setRows(5);
        jScrollPane3.setViewportView(areaNotificacion);

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mx/ipn/escuela/imagenes/server.png"))); // NOI18N

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(imagenServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInicioLayout.createSequentialGroup()
                                .addComponent(botonIniciar)
                                .addGap(18, 18, 18)
                                .addComponent(botonParar))
                            .addComponent(etiquetaEstado)))
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(etiquetaPuerto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaEstado)
                    .addComponent(etiquetaPuerto))
                .addGap(11, 11, 11)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagenServidor)
                    .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonIniciar)
                        .addComponent(botonParar)
                        .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addGroup(panelInicioLayout.createSequentialGroup()
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenu1.setText("File");

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void botonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPararActionPerformed
        // TODO add your handling code here:
        botonIniciar.setEnabled(true);
        botonParar.setEnabled(false);
        textoPuerto.setEnabled(true);
    }//GEN-LAST:event_botonPararActionPerformed

    private void botonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIniciarActionPerformed
        // TODO add your handling code here:
        botonIniciar.setEnabled(false);
        botonParar.setEnabled(true);
        textoPuerto.setEnabled(false);
        hiloServidor = new HiloServidor(Integer.valueOf(textoPuerto.getText()), areaNotificacion);
        hiloServidor.start();
    }//GEN-LAST:event_botonIniciarActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IGServidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IGServidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaNotificacion;
    private javax.swing.JButton botonIniciar;
    private javax.swing.JButton botonParar;
    private javax.swing.JLabel etiquetaEstado;
    private javax.swing.JLabel etiquetaPuerto;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel imagenServidor;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JTextField textoPuerto;
    // End of variables declaration//GEN-END:variables

}
