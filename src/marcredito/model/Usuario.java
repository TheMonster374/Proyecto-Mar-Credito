package marcredito.model;

/**
 * Clase general de usuario, base para herencia.
 */
public abstract class Usuario {
    private final String id;
    private final String nombre;
    private final String correo;

    /**
     * Constructor de usuario.
     */
    public Usuario(String id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", correo=" + correo + '}';
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }
    
}
