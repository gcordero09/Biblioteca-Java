package tech.calaverita.idao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import tech.calaverita.bd.Conexion;
import tech.calaverita.dao.IUsuarioDao;
import tech.calaverita.models.Usuario;
import tech.calaverita.views.Autores;
import tech.calaverita.views.Usuarios;

public class UsuarioDaoJdbc implements IUsuarioDao {

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT * FROM usuarios";
    private static final String SQL_INSERT = "INSERT INTO usuarios(nombre, programa, fecha_nacimiento, correo, password) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, programa = ?, fecha_nacimiento = ?, correo = ?, password = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";

    @Override
    public void seleccionar(Usuarios usuarios) throws SQLException {
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
            list[i][2] = re.getString("programa");
            list[i][3] = re.getString("fecha_nacimiento");
            list[i][4] = re.getString("correo");
            list[i][5] = re.getString("password");
            i++;
        }

        usuarios.getTable().setModel(new javax.swing.table.DefaultTableModel(
                list,
                new String[]{
                    "Id", "Nombre", "Programa", "Fecha de Nacimiento", "Correo", "Password"
                }));
    }
    
//    @Override
//    public List<Usuario> seleccionar() throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Usuario usuario = null;
//        List<Usuario> usuarios = new ArrayList<>();
//
//        try {
//            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nombre = rs.getString("nombre");
//                String programa = rs.getString("programa");
//                String fechaNacimiento = rs.getString("fecha_nacimiento");
//                String correo = rs.getString("correo");
//                String password = rs.getString("password");
//
//                usuario = new Usuario(id, nombre, programa, fechaNacimiento, correo, password);
//                usuarios.add(usuario);
//            }
//        } finally {
//            Conexion.close(rs);
//            Conexion.close(stmt);
//            if (this.conexionTransaccional == null) {
//                Conexion.close(conn);
//            }
//        }
//        return usuarios;
//    }

    @Override
    public int insertar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getPrograma());
            stmt.setString(3, usuario.getFechaNacimiento());
            stmt.setString(4, usuario.getCorreo());
            stmt.setString(5, usuario.getPassword());
            registros = stmt.executeUpdate();
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(stmt);
            }
        }
        return registros;
    }

    @Override
    public int eliminar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getId());
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
    public int actualizar(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, usuario.getId());
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
