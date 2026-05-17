package marcredito.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import marcredito.controller.ControladorBanco;
import marcredito.model.Prestamo;
import marcredito.model.Prestamista;
import marcredito.model.Solicitante;
import marcredito.model.Usuario;

public class MenuSolicitante extends JFrame {

    private final ControladorBanco controller;
    private final Solicitante solicitante;

    private final DefaultTableModel modeloTabla;
    private final JTable tablaSolicitudes;
    private final JScrollPane scrollTabla;
    private final JLabel lblSinSolicitudes;
    private final JButton btnNuevaSolicitudGrande;
    private final JButton btnNuevaSolicitudMini;
    private final CardLayout cardLayout;
    private final JPanel panelContenido;

    public MenuSolicitante(ControladorBanco controller, Solicitante solicitante) {
        this.controller = controller;
        this.solicitante = solicitante;

        setTitle("Menú Solicitante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 550);
        setLocationRelativeTo(null);

        modeloTabla = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Monto", "Plazo", "Estado"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaSolicitudes = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaSolicitudes);

        lblSinSolicitudes = new JLabel("No hay solicitudes pendientes", SwingConstants.CENTER);

        btnNuevaSolicitudGrande = new JButton("Nueva Solicitud");
        btnNuevaSolicitudGrande.setPreferredSize(new Dimension(280, 70));
        btnNuevaSolicitudGrande.addActionListener(e -> abrirFormularioNuevaSolicitud());

        btnNuevaSolicitudMini = new JButton("Nueva Solicitud");
        btnNuevaSolicitudMini.setPreferredSize(new Dimension(150, 35));
        btnNuevaSolicitudMini.addActionListener(e -> abrirFormularioNuevaSolicitud());

        JPanel panelCentro = new JPanel(new BorderLayout(10, 10));
        panelCentro.add(lblSinSolicitudes, BorderLayout.CENTER);

        JPanel panelBotonGrande = new JPanel();
        panelBotonGrande.add(btnNuevaSolicitudGrande);
        panelCentro.add(panelBotonGrande, BorderLayout.SOUTH);

        JPanel panelTabla = new JPanel(new BorderLayout(10, 10));
        panelTabla.add(scrollTabla, BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel();
        panelAcciones.add(btnNuevaSolicitudMini);
        panelTabla.add(panelAcciones, BorderLayout.SOUTH);

        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);
        panelContenido.add(panelCentro, "VACIO");
        panelContenido.add(panelTabla, "TABLA");

        add(panelContenido);

        cargarSolicitudes();
        actualizarVista();
    }

    public MenuSolicitante() {
        this.controller = null;
        this.solicitante = null;

        modeloTabla = new DefaultTableModel();
        tablaSolicitudes = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tablaSolicitudes);
        lblSinSolicitudes = new JLabel("No hay solicitudes pendientes");
        btnNuevaSolicitudGrande = new JButton("Nueva Solicitud");
        btnNuevaSolicitudMini = new JButton("Nueva Solicitud");
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);
    }

    private void cargarSolicitudes() {
        modeloTabla.setRowCount(0);

        List<Prestamo> prestamos = controller.obtenerPrestamosDeUsuario(solicitante.getId());
        for (Prestamo prestamo : prestamos) {
            modeloTabla.addRow(new Object[]{
                prestamo.getIdPrestamo(),
                prestamo.getMonto(),
                prestamo.getAcuerdo().getPlazoMeses(),
                prestamo.getEstado()
            });
        }
    }

    private void actualizarVista() {
        boolean hayPrestamos = modeloTabla.getRowCount() > 0;

        if (hayPrestamos) {
            cardLayout.show(panelContenido, "TABLA");
        } else {
            cardLayout.show(panelContenido, "VACIO");
        }
    }

    private void abrirFormularioNuevaSolicitud() {
        String montoTexto = JOptionPane.showInputDialog(this, "Ingrese el monto solicitado:");
        if (montoTexto == null) {
            return;
        }

        String plazoTexto = JOptionPane.showInputDialog(this, "Ingrese el plazo en meses:");
        if (plazoTexto == null) {
            return;
        }

        double monto;
        int plazo;

        try {
            monto = Double.parseDouble(montoTexto.trim());
            plazo = Integer.parseInt(plazoTexto.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Monto o plazo inválido.");
            return;
        }

        if (monto <= 0 || plazo <= 0) {
            JOptionPane.showMessageDialog(this, "Monto y plazo deben ser mayores a 0.");
            return;
        }

        String idPrestamista = obtenerPrestamistaDisponible();
        if (idPrestamista == null) {
            JOptionPane.showMessageDialog(this, "No hay prestamistas disponibles.");
            return;
        }

        controller.crearPrestamo(monto, plazo, 5.0, solicitante.getId(), idPrestamista);
        cargarSolicitudes();
        actualizarVista();
    }

    private String obtenerPrestamistaDisponible() {
        Usuario usuarioP1 = controller.buscarUsuarioPorId("P1");
        if (usuarioP1 instanceof Prestamista) {
            return usuarioP1.getId();
        }

        List<Prestamo> prestamos = controller.getPrestamos();
        for (Prestamo prestamo : prestamos) {
            Prestamista prestamista = prestamo.getPrestamista();
            if (prestamista != null) {
                return prestamista.getId();
            }
        }

        return null;
    }
}
