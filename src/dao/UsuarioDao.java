package dao;

import model.Movimiento;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends AbstractDao {
    private static UsuarioDao instancia = null;

    private UsuarioDao() {

    }

    public static UsuarioDao getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioDao();
        }

        return instancia;
    }

    @Override
    public void insert(Object obj) {

    }

    @Override
    public void update(Object obj) {

    }

    @Override
    public void delete(Object obj) {

    }

    public Usuario getUsuario(String username) {
        Usuario usu = new Usuario();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            String sql = "Select * From usuarios Where username = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usu.setUsername(rs.getString("username"));
                usu.setPassword(rs.getString("password"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setMovimientos(getAllMovimientos(username));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return usu;
    }

    public List<Usuario> getAll() {
        List<Usuario> listado = new ArrayList<>();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("Select * From usuarios");

            while (rs.next()) {
                Usuario usu = new Usuario();

                usu.setUsername(rs.getString("username"));
                usu.setPassword(rs.getString("password"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));

                listado.add(usu);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return listado;
    }

    public List<Movimiento> getAllMovimientos(String username) {
        List<Movimiento> listado = new ArrayList<>();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            String sql = "Select * From movimientos Where username = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Movimiento mov = new Movimiento();

                mov.setIdMovimiento(rs.getInt("id"));
                mov.setFecha(rs.getDate("fecha"));
                mov.setEmpresa(EmpresaDao.getInstancia().getEmpresa(rs.getInt("idEmpresa")));
                mov.setLugar(LugarDao.getInstancia().getLugar(rs.getInt("idLugar")));
                mov.setTarea(TareaDao.getInstancia().getTarea(rs.getInt("idTarea")));
                mov.setDetalle(rs.getString("detalle"));
                mov.setComentario(rs.getString("comentario"));
                mov.setHoras(rs.getDouble("horas"));

                listado.add(mov);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return listado;
    }
}
