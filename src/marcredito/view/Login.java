package marcredito.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import marcredito.controller.ControladorBanco;
import marcredito.model.Usuario;

public class Login extends javax.swing.JFrame {

    private static final String PLACEHOLDER_ID = "Ingrese su ID";

    private ControladorBanco controller;

    public Login() {
        this(null);
    }

    public Login(ControladorBanco controller) {
        this.controller = controller;
        initComponents();
        inicializarPlaceholder();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        lblIconoUsuario = new javax.swing.JLabel();
        lblIconoSeguro = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mar Crédito - Login");
        setResizable(false);

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mar Credito logo 2.0.png")));
        panelPrincipal.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 70));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("INICIO DE SESIÓN");
        panelPrincipal.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 14));
        txtId.setForeground(new java.awt.Color(153, 153, 153));
        txtId.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdFocusGained(evt);
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        panelPrincipal.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 280, 40));

        btnIngresar.setBackground(new java.awt.Color(0, 102, 153));
        btnIngresar.setFont(new java.awt.Font("Segoe UI", 1, 14));
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("INGRESAR");
        btnIngresar.setBorderPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 280, 40));

        lblIconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png")));
        panelPrincipal.add(lblIconoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 40, 40));

        lblIconoSeguro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/verified.png")));
        panelPrincipal.add(lblIconoSeguro, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 40, 40));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FONDO GUI.png")));
        panelPrincipal.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void inicializarPlaceholder() {
        txtId.setText(PLACEHOLDER_ID);
        txtId.setForeground(Color.GRAY);
    }

    private void txtIdFocusGained(java.awt.event.FocusEvent evt) {
        if (PLACEHOLDER_ID.equals(txtId.getText())) {
            txtId.setText("");
            txtId.setForeground(Color.BLACK);
        }
    }

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {
        if (txtId.getText().trim().isEmpty()) {
            txtId.setText(PLACEHOLDER_ID);
            txtId.setForeground(Color.GRAY);
        }
    }

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        if (controller == null) {
            JOptionPane.showMessageDialog(this,
                    "No hay controlador configurado.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String id = txtId.getText().trim();
        if (id.isEmpty() || PLACEHOLDER_ID.equals(id)) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un ID válido.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Usuario usuario = controller.buscarUsuarioPorId(id);
        if (usuario != null) {
            JOptionPane.showMessageDialog(this,
                    "Bienvenido, " + usuario.getNombre() + " (" + usuario.getId() + ")",
                    "Acceso concedido",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "No existe un usuario con ID: " + id,
                    "Acceso denegado",
                    JOptionPane.WARNING_MESSAGE);
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblIconoSeguro;
    private javax.swing.JLabel lblIconoUsuario;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtId;
    // End of variables declaration
}
