package Navios;

import java.util.ArrayList;

public class Pantalan {
    private int id;
    static ArrayList<Amarre> listAmarre;
    private String tipo;
    private static int contadorPantalan = 0;

    //getters i setters

    public int getId() {
        return id;
    }

    public void setId(int contadorPantalan) {
        contadorPantalan++;
        this.id = contadorPantalan;
    }

    public ArrayList<Amarre> getListAmarre() {
        return listAmarre;
    }

    public void setListAmarre(ArrayList<Amarre> listAmarre) {
        Pantalan.listAmarre = listAmarre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static int getContadorPantalan() {
        return contadorPantalan;
    }

    //constructores

    public Pantalan() {
        this.id = 0;
        Pantalan.listAmarre = new ArrayList<Amarre>();
        this.tipo = "";
    }

    public Pantalan(int id, ArrayList<Amarre> listAmarre, String tipo) {
        this.id = id;
        Pantalan.listAmarre = listAmarre;
        this.tipo = tipo;
    }

    //métodos

    @Override
    public String toString() {
        return "Pantalan{" +
                "id=" + id +
                ", listAmarre=" + listAmarre +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
