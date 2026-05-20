package marcredito.view;

import java.io.IOException;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import marcredito.controller.ControladorBanco;
import java.util.List;
import marcredito.model.Prestamo;


public class MenuSolicitante extends javax.swing.JFrame {
        
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuSolicitante.class.getName());

    private final ControladorBanco controller;
    private final marcredito.model.Solicitante solicitante;

    public MenuSolicitante(ControladorBanco controller, marcredito.model.Solicitante solicitante) {

        this.controller = controller;
        this.solicitante = solicitante;
        initComponents();
        configurarTabla();        
        cargarSolicitudes();
        actualizarVista();
    } 
                
        
    public MenuSolicitante() {
        controller = null;
        solicitante = null;
        initComponents();
    }
    
    
    
    private void configurarTabla() {
    DefaultTableModel nuevoModelo = new DefaultTableModel(
        new Object[][]{},
        new String[]{"ID", "Solicitante", "Monto", "Plazo", "Total", "Estado"}
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    tablaSolicitudes.setModel(nuevoModelo);

    tablaSolicitudes.setEnabled(true);
    tablaSolicitudes.setRowSelectionAllowed(true);
    tablaSolicitudes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    tablaSolicitudes.setTableHeader(null);
    jScrollPane1.setColumnHeaderView(null);
    
    btnNuevaSolicitudMini1.addActionListener((java.awt.event.ActionEvent e) -> {
        try {
            nuevaSolicitud();
        } catch (IOException ex) {
            System.getLogger(MenuSolicitante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
         }
        });
    }
    private void cargarSolicitudes() {

        DefaultTableModel modelo = (DefaultTableModel) tablaSolicitudes.getModel();
        modelo.setRowCount(0); 
        List<Prestamo> prestamos = controller.obtenerPrestamosDeUsuario(solicitante.getId());
        
        for (Prestamo p : prestamos) {

            modelo.addRow(new Object[]{
                p.getIdPrestamo(),
                solicitante.getNombre(),
                p.getMonto(),
                p.getAcuerdo().getPlazoMeses() + " meses",
                p.calcularTotalPagar(),
                p.getEstado()
            });
        }
    }
    
    private void nuevaSolicitud() throws IOException {

        marcredito.model.Prestamista prestamista = controller.obtenerPrimerPrestamista();
        
        if (prestamista == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No hay prestamistas disponibles en el sistema.",  "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String montoStr = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el monto del préstamo ($):", "Nueva Solicitud", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (montoStr == null || montoStr.trim().isEmpty()) return;
        
        double monto;
        
        try {
            monto = Double.parseDouble(montoStr.trim().replace(",", "."));            
            if (monto <= 0) throw new NumberFormatException();
            
        } catch (NumberFormatException e) {            
            javax.swing.JOptionPane.showMessageDialog(this, "El monto debe ser un número mayor a 0.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        String plazoStr = javax.swing.JOptionPane.showInputDialog(this, "Ingrese el plazo en meses:", "Nueva Solicitud", javax.swing.JOptionPane.QUESTION_MESSAGE);
        if (plazoStr == null || plazoStr.trim().isEmpty()) return;

        int plazo;
        try {
            plazo = Integer.parseInt(plazoStr.trim());
            if (plazo <= 0) throw new NumberFormatException();
            
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "El plazo debe ser un número entero mayor a 0.",
                "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        controller.crearPrestamo(monto, plazo, 5.0, solicitante.getId(), prestamista.getId());

        cargarSolicitudes();
        actualizarVista();

        javax.swing.JOptionPane.showMessageDialog(this, "¡Solicitud creada exitosamente! Interés: 5%", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void actualizarVista() {

        tablaSolicitudes.setTableHeader(null);
        tablaSolicitudes.setEnabled(true); 
        tablaSolicitudes.setRowSelectionAllowed(true);
        tablaSolicitudes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        if (tablaSolicitudes.getRowCount() == 0) {
            //Mostrar tabla vacia
            lblSinSolicitudes.setVisible(true);
            btnNuevaSolicitudGrande.setVisible(true);
            
            //Ocultar tabla
            tablaSolicitudes.setVisible(false);
            jScrollPane1.setVisible(false);
            btnNuevaSolicitudMini1.setVisible(false);
            btnVerDetalles.setVisible(false);
            } else {
                lblSinSolicitudes.setVisible(false);
                btnNuevaSolicitudGrande.setVisible(false);
                
                //Mostrar tabla
                tablaSolicitudes.setVisible(true);
                jScrollPane1.setVisible(true);
                btnNuevaSolicitudMini1.setVisible(true);
                btnVerDetalles.setVisible(true);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSinSolicitudes = new javax.swing.JLabel();
        btnNuevaSolicitudGrande = new javax.swing.JButton();
        btnVerDetalles = new javax.swing.JButton();
        btnNuevaSolicitudMini1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSolicitudes = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSinSolicitudes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblSinSolicitudes.setText("¡No hay solicitudes pendientes!");
        getContentPane().add(lblSinSolicitudes, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        btnNuevaSolicitudGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bttn_new_s.png"))); // NOI18N
        btnNuevaSolicitudGrande.setBorder(null);
        btnNuevaSolicitudGrande.setBorderPainted(false);
        btnNuevaSolicitudGrande.setContentAreaFilled(false);
        btnNuevaSolicitudGrande.setFocusPainted(false);
        btnNuevaSolicitudGrande.addActionListener(this::btnNuevaSolicitudGrandeActionPerformed);
        getContentPane().add(btnNuevaSolicitudGrande, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 210, 70));

        btnVerDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bttn_details_s.png"))); // NOI18N
        btnVerDetalles.setBorderPainted(false);
        btnVerDetalles.setContentAreaFilled(false);
        btnVerDetalles.setDefaultCapable(false);
        btnVerDetalles.addActionListener(this::btnVerDetallesActionPerformed);
        getContentPane().add(btnVerDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 427, 90, 30));

        btnNuevaSolicitudMini1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bttn_new_s2.png"))); // NOI18N
        btnNuevaSolicitudMini1.setBorderPainted(false);
        btnNuevaSolicitudMini1.setContentAreaFilled(false);
        btnNuevaSolicitudMini1.setDefaultCapable(false);
        getContentPane().add(btnNuevaSolicitudMini1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, -1, -1));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setOpaque(false);

        tablaSolicitudes.setBackground(new java.awt.Color(219, 219, 219));
        tablaSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Solicitante", "Monto", "Plazo", "Interes", "Estado"
            }
        ));
        tablaSolicitudes.setEnabled(false);
        tablaSolicitudes.setOpaque(false);
        tablaSolicitudes.setRowSelectionAllowed(false);
        tablaSolicitudes.setShowGrid(false);
        tablaSolicitudes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tablaSolicitudesAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tablaSolicitudes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaSolicitudesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaSolicitudes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 580, 210));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bkg_solici.png"))); // NOI18N
        Fondo.setText("jLabel1");
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
       int fila = tablaSolicitudes.getSelectedRow();
        if (fila < 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "Por favor selecciona una solicitud de la tabla.",
                "Sin selección", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel modelo = (DefaultTableModel) tablaSolicitudes.getModel();
        String id = String.valueOf(modelo.getValueAt(fila, 0));

        Prestamo prestamo = null;
        for (Prestamo p : controller.getPrestamos()) {
            if (p.getIdPrestamo().equals(id)) {
                prestamo = p;
                break;
            }
        }
        if (prestamo == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "No se encontró el préstamo.");
            return;
        }

        String mensaje = "ID: " + id + "\n"
                + "Solicitante: " + prestamo.getSolicitante().getNombre() + "\n"
                + "Monto: $" + prestamo.getMonto() + "\n"
                + "Plazo: " + prestamo.getAcuerdo().getPlazoMeses() + " meses\n"
                + "Interés: " + prestamo.getAcuerdo().getInteres() + "%\n"
                + "Total a pagar: " + prestamo.calcularTotalPagar() + "\n"
                + "Estado: " + prestamo.getEstado();

        if (!prestamo.getEstado().equalsIgnoreCase("Pendiente")
            && prestamo.getMotivo() != null && !prestamo.getMotivo().trim().isEmpty()) {
            mensaje += "\nMotivo: " + prestamo.getMotivo();
        }

        javax.swing.JOptionPane.showMessageDialog(this, mensaje, "Detalles de la Solicitud", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void btnNuevaSolicitudGrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaSolicitudGrandeActionPerformed
        try {
            nuevaSolicitud();
        } catch (IOException ex) {
            System.getLogger(MenuSolicitante.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }//GEN-LAST:event_btnNuevaSolicitudGrandeActionPerformed

    private void tablaSolicitudesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tablaSolicitudesAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaSolicitudesAncestorAdded

    private void tablaSolicitudesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaSolicitudesMouseClicked
    
    }//GEN-LAST:event_tablaSolicitudesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuSolicitante().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnNuevaSolicitudGrande;
    private javax.swing.JButton btnNuevaSolicitudMini1;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSinSolicitudes;
    private javax.swing.JTable tablaSolicitudes;
    // End of variables declaration//GEN-END:variables
}
