package tech.calaverita.dao;

import java.sql.SQLException;
import java.util.List;
import tech.calaverita.models.Usuario;
import tech.calaverita.views.Usuarios;

public interface IUsuarioDao {

//    public List<Usuario> seleccionar() throws SQLException;
    public void seleccionar(Usuarios usuarios) throws SQLException;

    public int insertar(Usuario usuario) throws SQLException;

    public int eliminar(Usuario usuario) throws SQLException;

    public int actualizar(Usuario usuario) throws SQLException;
}
