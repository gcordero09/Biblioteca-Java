package tech.calaverita.dao;

import java.sql.SQLException;
import java.util.List;
import tech.calaverita.models.Libro;
import tech.calaverita.views.Libros;

public interface ILibroDao {
    
//    public List<Libro> seleccionar() throws SQLException;
    public void seleccionar(Libros libros) throws SQLException;

    public int insertar(Libro libro) throws SQLException;

    public int eliminar(Libro libro) throws SQLException;

    public int actualizar(Libro libro) throws SQLException;
    
    public void buscar(String valor, Libros libros) throws SQLException;
}
