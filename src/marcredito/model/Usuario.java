package marcredito.model;

public abstract class Usuario {
    private final String id;
    private final String nombre;
    private final String correo;

    /**
     * Crea un usuario.
     *
     * @param id identificador
     * @param nombre nombre del usuario
     * @param correo correo del usuario
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
     * Obtiene el id.
     *
     * @return id del usuario
     */
    public String getId() {
        return id;
    }    

    /**
     * Obtiene el nombre.
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el correo.
     *
     * @return correo del usuario
     */
    public String getCorreo() {
        return correo;
    }
    
}
