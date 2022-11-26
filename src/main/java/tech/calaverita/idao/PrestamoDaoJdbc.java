package tech.calaverita.idao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tech.calaverita.bd.Conexion;
import tech.calaverita.dao.IPrestamoDao;
import tech.calaverita.models.Prestamo;
import tech.calaverita.views.Autores;
import tech.calaverita.views.Prestamos;

public class PrestamoDaoJdbc implements IPrestamoDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM prestamos";
    private static final String SQL_INSERT = "INSERT INTO prestamos(fecha_prestamo, fecha_devolucion, devuelto, usuario_id, libro_id) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE prestamos SET fecha_prestamo = ?, fecha_devolucion = ?, devuelto = ?, usuario_id = ?, libro_id = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM prestamos WHERE id = ?";

    @Override
    public void seleccionar(Prestamos prestamos) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet counter = stmt.executeQuery();

        int count = 0;
        while (counter.next()) {
            count++;
        }

        String list[][] = new String[count][6];
        int i = 0;
        ResultSet re = stmt.executeQuery();
        while (re.next()) {
            list[i][0] = re.getString("id");
            list[i][1] = re.getString("nombre");
            list[i][2] = re.getString("nacionalidad");
            i++;
        }

        prestamos.getTable().setModel(new javax.swing.table.DefaultTableModel(
                list,
                new String[]{
                    "Id", "Nombre", "Nacionalidad"
                }));
    }
    
//    @Override
//    public List<Prestamo> seleccionar() throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Prestamo prestamo = null;
//        List<Prestamo> prestamos = new ArrayList<>();
//
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String fechaPrestamo = rs.getString("fecha_prestamo");
//                String fechaDevolucion = rs.getString("fecha_devolucion");
//                boolean isDevuelto = rs.getBoolean("devuelto");
//                int usuarioId = rs.getInt("usuario_id");
//                int libroId = rs.getInt("libro_id");
//
//                prestamo = new Prestamo(id, fechaPrestamo, fechaDevolucion, isDevuelto, usuarioId, libroId);
//                prestamos.add(prestamo);
//            }
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            if (this.conexionTransaccional == null) {
//                Conexion.close(conn);
//            }
//        }
//
//        return prestamos;
//    }

    @Override
    public int insertar(Prestamo prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, prestamo.getFechaPrestamo());
            stmt.setString(2, prestamo.getFechaDevolucion());
            stmt.setBoolean(3, prestamo.isIsDevuelto());
            stmt.setInt(4, prestamo.getUsuarioId());
            stmt.setInt(5, prestamo.getLibroId());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }

    @Override
    public int eliminar(Prestamo prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, prestamo.getId());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }
        return registros;
    }

    @Override
    public int actualizar(Prestamo prestamo) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, prestamo.getFechaPrestamo());
            stmt.setString(2, prestamo.getFechaDevolucion());
            stmt.setBoolean(3, prestamo.isIsDevuelto());
            stmt.setInt(4, prestamo.getUsuarioId());
            stmt.setInt(5, prestamo.getLibroId());
            stmt.setInt(6, prestamo.getId());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }
        return registros;
    }

}
