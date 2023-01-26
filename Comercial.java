package Navios;

public class Comercial extends Barco {
    private String carga;

    //getters i setters

    public String getCarga() {
        return carga;
    }

    public void setCarga(String carga) {
        this.carga = carga;
    }

    //constructores

    public Comercial(){
        this.carga = "";
    }

    public Comercial( String matricula, String nombre, float tamano, String carga) {
        super(matricula, nombre, tamano);
        this.carga = carga;
    }

    //metodos

    @Override
    public String toString() {
        return "Comercial {" + "Carga: " + carga+ "," ;
    }
}
