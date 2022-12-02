package tech.calaverita.dao;

import java.sql.SQLException;
import java.util.List;
import tech.calaverita.models.Prestamo;
import tech.calaverita.views.Prestamos;

public interface IPrestamoDao {
    
//    public List<Prestamo> seleccionar() throws SQLException;
    public void seleccionar(Prestamos prestamos) throws SQLException;

    public int insertar(Prestamo prestamo) throws SQLException;

    public int eliminar(Prestamo prestamo) throws SQLException;

    public int actualizar(Prestamo prestamo) throws SQLException;
    
    public void buscar(String valor, Prestamos prestamos) throws SQLException;
    
    public int devolver(Prestamo prestamo) throws SQLException;
}
