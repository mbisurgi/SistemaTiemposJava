package dao;

import model.Tarea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TareaDao extends AbstractDao {
    private static TareaDao instancia = null;

    private TareaDao() {

    }

    public static TareaDao getInstancia() {
        if (instancia == null) {
            instancia = new TareaDao();
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

    public Tarea getTarea(int idTarea) {
        Tarea tar = new Tarea();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            String sql = "Select * From tareas Where id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                tar.setIdTarea(rs.getInt("id"));
                tar.setNombreTarea(rs.getString("nombreTarea"));
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            System.out.println("Stack Trace: " + ex.getStackTrace());
        } finally {
            PoolConnection.getInstancia().releaseConnection(con);
        }

        return tar;
    }

    public List<Tarea> getAll() {
        List<Tarea> listado = new ArrayList<>();

        Connection con = PoolConnection.getInstancia().getConnection();

        try {
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("Select * From tareas");

            while (rs.next()) {
                Tarea tar = new Tarea();

                tar.setIdTarea(rs.getInt("id"));
                tar.setNombreTarea(rs.getString("nombreTarea"));

                listado.add(tar);
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
