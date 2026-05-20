package marcredito.persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import marcredito.model.Prestamo;
import marcredito.model.Usuario;

public class Persistencia implements Serializable {
    private static final String ARCHIVO_PRESTAMOS = "prestamos.dat";
    private static final String ARCHIVO_USUARIOS = "usuarios.dat";

    public boolean guardarPrestamos(List<Prestamo> lista) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PRESTAMOS))) {
            out.writeObject(lista);
        }
        return true;
    }
    

    public List<Prestamo> listarPrestamos() throws IOException, ClassNotFoundException {
        List<Prestamo> lista = new ArrayList<>();
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_PRESTAMOS))) {
                lista = (List<Prestamo>) in.readObject();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe archivo de préstamos.");
            // Aquí NO RETURNES NULO, debe mantener la lista vacía
        }
        // Asegura que nunca devuelves null
        if (lista == null) {
            lista = new ArrayList<>();
        }
        return lista;
    }

    // --- MÉTODOS PARA USUARIOS ---

    public boolean guardarUsuario(Usuario usuario) throws IOException, ClassNotFoundException {
        List<Usuario> lista = listarUsuarios();
        lista.add(usuario);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_USUARIOS))) {
            out.writeObject(lista);
        }
        return true;
    }
    
    public List<Usuario> listarUsuarios() throws IOException, ClassNotFoundException {
        List<Usuario> lista = new ArrayList<>();
        try {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_USUARIOS))) {
                lista = (List<Usuario>) in.readObject();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No existe archivo de usuarios.");
        }
        return lista;
    }

//    // --- Demostración main ---
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Persistencia p = new Persistencia();
////        // Ejemplo general: Listar préstamos
////        List<Prestamo> lista = p.listarPrestamos();
////        for (Prestamo pr : lista) {
////            System.out.println(pr.toString());
////        }
//        // Ejemplo: Guardar usuario (Solicitante)
//        Usuario s = new Prestamista("S1", "Ana", "ana@mar.com");
//        p.guardarUsuario(s);
//    }
}