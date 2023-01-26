package Navios;

public class Recreo extends Barco{
    private String permiso;

    //getters i setters

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    //constructores

    public Recreo(){
        this.permiso = "";
    }

    public Recreo(String matricula, String nombre, Float tamano, String permiso) {
        super(matricula, nombre, tamano);
        this.permiso = permiso;
    }

    //metodos

    @Override
    public String toString() {
        return "Recreo {" + "Permiso: " + permiso + ",";
    }
}
