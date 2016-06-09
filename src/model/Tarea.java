package model;

public class Tarea {
    private int idTarea;
    private String nombreTarea;

    public Tarea() {

    }

    public Tarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    @Override
    public String toString() {
        return nombreTarea;
    }
}
