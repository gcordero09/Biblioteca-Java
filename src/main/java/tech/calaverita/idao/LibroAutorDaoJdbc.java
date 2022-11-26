package tech.calaverita.idao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tech.calaverita.bd.Conexion;
import tech.calaverita.dao.ILibroAutorDao;
import tech.calaverita.models.Autor;
import tech.calaverita.models.LibroAutor;
import tech.calaverita.views.Autores;

public class LibroAutorDaoJdbc implements ILibroAutorDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM libros_autores";
    private static final String SQL_INSERT = "INSERT INTO libros_autores(libro_id, autor_id) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE libros_autores SET libro_id = ?, autor_id = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM libros_autores WHERE id = ?";

//    @Override
//    public void seleccionar(Autores autores) throws SQLException {
//        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
//        ResultSet counter = stmt.executeQuery();
//
//        int count = 0;
//        while (counter.next()) {
//            count++;
//        }
//
//        String list[][] = new String[count][6];
//        int i = 0;
//        ResultSet re = stmt.executeQuery();
//        while (re.next()) {
//            list[i][0] = re.getString("id");
//            list[i][1] = re.getString("nombre");
//            list[i][2] = re.getString("nacionalidad");
//            i++;
//        }
//
//        autores.getTable().setModel(new javax.swing.table.DefaultTableModel(
//                list,
//                new String[]{
//                    "Id", "Nombre", "Nacionalidad"
//                }));
//    }

//    @Override
//    public List<LibroAutor> seleccionar() throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        LibroAutor libroAutor = null;
//        List<LibroAutor> librosAutores = new ArrayList<>();
//
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String libroId = rs.getString("libro_id");
//                String autorId = rs.getString("autor_id");
//
//                libroAutor = new LibroAutor(id, libroId, autorId);
//                librosAutores.add(libroAutor);
//            }
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            if (this.conexionTransaccional == null) {
//                Conexion.close(conn);
//            }
//        }
//
//        return librosAutores;
//    }
    @Override
    public int insertar(LibroAutor libroAutor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, libroAutor.getLibroId());
            stmt.setString(2, libroAutor.getAutorId());
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
    public int eliminar(LibroAutor libroAutor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, libroAutor.getId());
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
    public int actualizar(LibroAutor libroAutor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, libroAutor.getLibroId());
            stmt.setString(2, libroAutor.getAutorId());
            stmt.setInt(3, libroAutor.getId());
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
