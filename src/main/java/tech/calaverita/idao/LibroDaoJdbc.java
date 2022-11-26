package tech.calaverita.idao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tech.calaverita.bd.Conexion;
import tech.calaverita.dao.ILibroDao;
import tech.calaverita.models.Libro;
import tech.calaverita.views.Autores;
import tech.calaverita.views.Libros;

public class LibroDaoJdbc implements ILibroDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM libros";
    private static final String SQL_INSERT = "INSERT INTO libros(titulo, editorial, area, cover_url, digital_url, disponible_fisico) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE libros SET titulo = ?, editorial = ?, area = ?, cover_url = ?, digital_url = ?, disponible_fisico = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM libros WHERE id = ?";

    @Override
    public void seleccionar(Libros libros) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet counter = stmt.executeQuery();

        int count = 0;
        while (counter.next()) {
            count++;
        }

        String list[][] = new String[count][7];
        int i = 0;
        ResultSet re = stmt.executeQuery();
        while (re.next()) {
            list[i][0] = re.getString("id");
            list[i][1] = re.getString("titulo");
            list[i][2] = re.getString("editorial");
            list[i][3] = re.getString("area");
            list[i][4] = re.getString("cover_url");
            list[i][5] = re.getString("digital_url");
            list[i][6] = re.getString("disponible_fisico");
            i++;
        }

        libros.getTable().setModel(new javax.swing.table.DefaultTableModel(
                list,
                new String[]{
                    "Id", "Titulo", "Editorial", "Area", "Url de Cover", "Url de Digital", "Disponible en Físico"
                }));
    }

//    @Override
//    public List<Libro> seleccionar() throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Libro libro = null;
//        List<Libro> libros = new ArrayList<>();
//
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String titulo = rs.getString("titulo");
//                String editorial = rs.getString("editorial");
//                String area = rs.getString("area");
//                String coverUrl = rs.getString("cover_url");
//                String digitalUrl = rs.getString("digital_url");
//                boolean disponibleFisico = rs.getBoolean("disponible_fisico");
//
//                libro = new Libro(id, titulo, editorial, area, coverUrl, digitalUrl, disponibleFisico);
//                libros.add(libro);
//            }
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            if (this.conexionTransaccional == null) {
//                Conexion.close(conn);
//            }
//        }
//
//        return libros;
//    }
    @Override
    public int insertar(Libro libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getEditorial());
            stmt.setString(3, libro.getArea());
            stmt.setString(4, libro.getCoverUrl());
            stmt.setString(5, libro.getDigitalUrl());
            stmt.setBoolean(6, libro.isIsDisponibleFisico());
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
    public int eliminar(Libro libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, libro.getId());
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
    public int actualizar(Libro libro) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getEditorial());
            stmt.setString(3, libro.getArea());
            stmt.setString(4, libro.getCoverUrl());
            stmt.setString(5, libro.getDigitalUrl());
            stmt.setBoolean(6, libro.isIsDisponibleFisico());
            stmt.setInt(7, libro.getId());
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
