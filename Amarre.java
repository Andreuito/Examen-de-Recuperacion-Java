package Navios;

public class Amarre {
    private int id;
    private float tamanoAmarre;
    private boolean ocupado;
    private Barco barco;
    private static int contadorAmarres = 0;

    //getters i setters

    public int getId() {
        return id;
    }

    public void setId(int contadorAmarres) {
        contadorAmarres++;
        this.id = contadorAmarres;
    }

    public float getTamanoAmarre() {
        return tamanoAmarre;
    }

    public void setTamanoAmarre(float tamanoAmarre) {
        this.tamanoAmarre = tamanoAmarre;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public static int getContadorAmarres() {
        return contadorAmarres;
    }

    //constructores

    public Amarre(){
        this.id = 0;
        this.tamanoAmarre = 0;
        this.ocupado = false;
        this.barco = null;
    }

    public Amarre(float tamanoAmarre, boolean ocupado, Barco barco) {
        this.id = contadorAmarres;
        this.tamanoAmarre = tamanoAmarre;
        this.ocupado = ocupado;
        this.barco = barco;
    }

    //metodos

    @Override
    public String toString() {
        return "Amarre{" + "id= " + id + ", tamanoAmarre= " + tamanoAmarre + ", ocupado= " + ocupado + ", barco= " + barco + '}';
    }
}
