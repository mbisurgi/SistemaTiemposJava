package dao;

import model.Empresa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDao extends AbstractDao {
    private static EmpresaDao instancia = null;

    private EmpresaDao() {

    }

    public static EmpresaDao getInstancia() {
        if (instancia == null) {
            instancia = new EmpresaDao();
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

    public Empresa getEmpresa(int idEmpresa) {
        Empresa emp = new Empresa();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            String sql = "Select * From empresas Where id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEmpresa);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp.setIdEmpresa(rs.getInt("id"));
                emp.setNombreEmpresa(rs.getString("nombreEmpresa"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return emp;
    }

    public List<Empresa> getAll() {
        List<Empresa> listado = new ArrayList<>();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("Select * From empresas");

            while (rs.next()) {
                Empresa emp = new Empresa();

                emp.setIdEmpresa(rs.getInt("id"));
                emp.setNombreEmpresa(rs.getString("nombreEmpresa"));

                listado.add(emp);
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
