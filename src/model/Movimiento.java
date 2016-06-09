package model;

import java.util.Calendar;
import java.sql.Date;

public class Movimiento {
    private int idMovimiento;
    private Date fecha;
    private Empresa empresa;
    private Lugar lugar;
    private Tarea tarea;
    private String detalle;
    private String comentario;
    private double horas;

    public Movimiento() {

    }

    public Movimiento(Date fecha, Empresa empresa, Lugar lugar, Tarea tarea, String detalle, String comentario, double horas) {
        this.fecha = fecha;
        this.empresa = empresa;
        this.lugar = lugar;
        this.tarea = tarea;
        this.detalle = detalle;
        this.comentario = comentario;
        this.horas = horas;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }
}
