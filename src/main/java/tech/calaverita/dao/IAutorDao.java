package tech.calaverita.dao;

import java.sql.SQLException;
import java.util.List;
import tech.calaverita.models.Autor;
import tech.calaverita.views.Autores;

public interface IAutorDao {
    
//    public List<Autor> seleccionar() throws SQLException;
    public void seleccionar(Autores autores) throws SQLException;

    public int insertar(Autor autor) throws SQLException;

    public int eliminar(Autor autor) throws SQLException;

    public int actualizar(Autor autor) throws SQLException;
    
    public void buscar(String valor, Autores autores) throws SQLException;
}
