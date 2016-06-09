package model;

public class Lugar {
    private int idLugar;
    private String nombreLugar;

    public Lugar() {

    }

    public Lugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    @Override
    public String toString() {
        return nombreLugar;
    }
}
