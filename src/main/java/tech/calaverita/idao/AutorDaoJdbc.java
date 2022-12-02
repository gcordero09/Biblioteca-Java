package tech.calaverita.idao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tech.calaverita.bd.Conexion;
import tech.calaverita.dao.IAutorDao;
import tech.calaverita.models.Autor;
import tech.calaverita.views.Autores;

public class AutorDaoJdbc implements IAutorDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM autores";
    private static final String SQL_INSERT = "INSERT INTO autores(nombre, nacionalidad) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE autores SET nombre = ?, nacionalidad = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM autores WHERE id = ?";
    private static final String SQL_SEARCH = "SELECT * FROM autores WHERE id = ? OR nombre = ?";

    public AutorDaoJdbc() {

    }

    public AutorDaoJdbc(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public void seleccionar(Autores autores) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
        ResultSet counter = stmt.executeQuery();

        int count = 0;
        while (counter.next()) {
            count++;
        }

        String list[][] = new String[count][3];
        int i = 0;
        ResultSet re = stmt.executeQuery();
        while (re.next()) {
            list[i][0] = re.getString("id");
            list[i][1] = re.getString("nombre");
            list[i][2] = re.getString("nacionalidad");
            i++;
        }

        autores.getTable().setModel(new javax.swing.table.DefaultTableModel(
                list,
                new String[]{
                    "Id", "Nombre", "Nacionalidad"
                }));
        Conexion.close(stmt);
        if (this.conexionTransaccional == null) {
            Conexion.close(conn);
        }
    }

//    @Override
//    public List<Autor> seleccionar() throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Autor autor = null;
//        List<Autor> autores = new ArrayList<>();
//
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nombre = rs.getString("nombre");
//                String nacionalidad = rs.getString("nacionalidad");
//
//                autor = new Autor(id, nombre, nacionalidad);
//                autores.add(autor);
//            }
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            if (this.conexionTransaccional == null) {
//                Conexion.close(conn);
//            }
//        }
//
//        return autores;
//    }
//
    @Override
    public int insertar(Autor autor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getNacionalidad());
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
    public int eliminar(Autor autor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, autor.getId());
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
    public int actualizar(Autor autor) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, autor.getNombre());
            stmt.setString(2, autor.getNacionalidad());
            stmt.setInt(3, autor.getId());
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
    public void buscar(String valor, Autores autores) throws SQLException {
        Connection conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
        PreparedStatement stmt = conn.prepareStatement(SQL_SEARCH);

        stmt.setString(1, valor);
        stmt.setString(2, valor);

        ResultSet counter = stmt.executeQuery();

        int count = 0;
        while (counter.next()) {
            count++;
        }

        String list[][] = new String[count][3];
        int i = 0;
        ResultSet re = stmt.executeQuery();
        while (re.next()) {
            list[i][0] = re.getString("id");
            list[i][1] = re.getString("nombre");
            list[i][2] = re.getString("nacionalidad");
            i++;
        }

        autores.getTable().setModel(new javax.swing.table.DefaultTableModel(
                list,
                new String[]{
                    "Id", "Nombre", "Nacionalidad"
                }));

    }

}
