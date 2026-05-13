package marcredito;

import marcredito.controller.ControladorBanco;
import marcredito.service.SistemaBanco;
import marcredito.view.Login;

public class App {
    public static void main(String[] args) {
        SistemaBanco sistema = new SistemaBanco();
        ControladorBanco controller = new ControladorBanco(sistema);

        java.awt.EventQueue.invokeLater(() -> {
            new Login(controller).setVisible(true);
        });
        // Usuarios de prueba (para login por ID)
        controller.registrarSolicitante("S1", "Ana", "ana@mail.com");
        controller.registrarPrestamista("P1", "Carlos", "carlos@mail.com");
    }
}
