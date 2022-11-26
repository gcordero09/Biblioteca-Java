package tech.calaverita.models;

public class Prestamo {

    private int id;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private boolean isDevuelto;
    private int usuarioId;
    private int libroId;

    public Prestamo(String fechaPrestamo, String fechaDevolucion, boolean isDevuelto, int usuarioId, int libroId) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.isDevuelto = isDevuelto;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }
    public Prestamo(int id, String fechaPrestamo, String fechaDevolucion, boolean isDevuelto, int usuarioId, int libroId) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.isDevuelto = isDevuelto;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isIsDevuelto() {
        return isDevuelto;
    }

    public void setIsDevuelto(boolean isDevuelto) {
        this.isDevuelto = isDevuelto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

}
