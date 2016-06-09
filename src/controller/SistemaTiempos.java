package controller;

import dao.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class SistemaTiempos {
    private static SistemaTiempos instancia = null;

    private Usuario usuarioLogueado;
    private List<Usuario> usuarios;
    private List<Empresa> empresas;
    private List<Lugar> lugares;
    private List<Tarea> tareas;

    private SistemaTiempos() {
        this.usuarios = UsuarioDao.getInstancia().getAll();
        this.empresas = EmpresaDao.getInstancia().getAll();
        this.lugares = LugarDao.getInstancia().getAll();
        this.tareas = TareaDao.getInstancia().getAll();
    }

    public static SistemaTiempos getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTiempos();
        }

        return instancia;
    }

    public boolean login(String username, String password) {
        Usuario usu = buscarUsuario(username);

        if (usu != null) {
            if (usu.getPassword().equals(password)) {
                usuarioLogueado = UsuarioDao.getInstancia().getUsuario(username);
                return true;
            }
        }

        return false;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    private Usuario buscarUsuario(String username) {
        for (Usuario usu: usuarios) {
            if (usu.getUsername().equals(username)) {
                return  usu;
            }
        }

        return null;
    }
}
