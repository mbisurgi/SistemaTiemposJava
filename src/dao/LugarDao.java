package dao;

import model.Lugar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LugarDao extends AbstractDao {
    private static LugarDao instancia  = null;

    private LugarDao() {

    }

    public static LugarDao getInstancia() {
        if (instancia == null) {
            instancia = new LugarDao();
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

    public Lugar getLugar(int idLugar) {
        Lugar lug = new Lugar();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            String sql = "Select * From lugares Where id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLugar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                lug.setIdLugar(rs.getInt("id"));
                lug.setNombreLugar(rs.getString("nombreLugar"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return lug;
    }

    public List<Lugar> getAll() {
        List<Lugar> listado = new ArrayList<>();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("Select * From lugares");

            while (rs.next()) {
                Lugar lug = new Lugar();

                lug.setIdLugar(rs.getInt("id"));
                lug.setNombreLugar(rs.getString("nombreLugar"));

                listado.add(lug);
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
