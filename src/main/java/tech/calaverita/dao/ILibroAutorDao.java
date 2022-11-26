package tech.calaverita.dao;

import java.sql.SQLException;
import java.util.List;
import tech.calaverita.models.LibroAutor;
import tech.calaverita.views.Autores;

public interface ILibroAutorDao {
    
//    public List<LibroAutor> seleccionar() throws SQLException;
//    public void seleccionar(LibrosAutores librosAutores) throws SQLException;

    public int insertar(LibroAutor libroAutor) throws SQLException;

    public int eliminar(LibroAutor libroAutor) throws SQLException;

    public int actualizar(LibroAutor libroAutor) throws SQLException;
}
