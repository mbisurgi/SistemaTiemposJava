package model;

public class Empresa {
    private int idEmpresa;
    private String nombreEmpresa;

    public Empresa() {

    }

    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return nombreEmpresa;
    }
}
