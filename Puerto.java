package Navios;

import java.util.ArrayList;
//import java.util.Scanner;
import java.io.IOException;

public class Puerto {
    static ArrayList<Barco> barcosEntrantes = new ArrayList<Barco>();
    static ArrayList<Pantalan> listPantalan = new ArrayList<Pantalan>();

    //getters i setters

    public ArrayList<Barco> getBarcosEntrantes() {
        return barcosEntrantes;
    }

    public void setBarcosEntrantes(ArrayList<Barco> barcosEntrantes) {
        Puerto.barcosEntrantes = barcosEntrantes;
    }

    public ArrayList<Pantalan> getListPantalan() {
        return listPantalan;
    }

    public void setListPantalan(ArrayList<Pantalan> listPantalan) {
        Puerto.listPantalan = listPantalan;
    }

    //constructores

    public Puerto() {
        Puerto.barcosEntrantes = new ArrayList<Barco>();
        Puerto.listPantalan = new ArrayList<Pantalan>();
    }

    public Puerto(ArrayList<Barco> barcosEntrantes, ArrayList<Pantalan> listPantalan) {
        Puerto.barcosEntrantes = barcosEntrantes;
        Puerto.listPantalan = listPantalan;
    }


    //métodos
    public static void buscarAmarre(ArrayList<Barco> barcosEntrantes, ArrayList<Pantalan> listPantalan){

        //ordenar amarres por capacidad
        for(int i = 0; i < listPantalan.size(); i++){
            for(int x = 1; x < listPantalan.size(); x++){
                for(int j = 0; j < Pantalan.listAmarre.size(); j++){
                    if(listPantalan.get(i).getListAmarre().get(j).getTamanoAmarre() > listPantalan.get(x).getListAmarre().get(j).getTamanoAmarre()){
                        Pantalan aux = listPantalan.get(i);
                        listPantalan.set(i, listPantalan.get(j));
                        listPantalan.set(j, aux);
                    }
                }
            }
        }

        System.out.println("llega?");
        for(int i = 0; i < listPantalan.size(); i++){
            System.out.println(listPantalan.get(i).getId() + " con capacidad de " + listPantalan.get(i).getListAmarre().get(i).getTamanoAmarre() + " metros");
        }

        System.out.println("Amarres ordenados por capacidad: ");

        //ordenar barcos por capacidad
        for(int i = 0; i < barcosEntrantes.size(); i++){
            for(int j = 0; j < barcosEntrantes.size(); j++){
                if(barcosEntrantes.get(i).getTamano() > barcosEntrantes.get(j).getTamano()){
                    Barco aux = barcosEntrantes.get(i);
                    barcosEntrantes.set(i, barcosEntrantes.get(j));
                    barcosEntrantes.set(j, aux);
                }
            }
        }

        System.out.println("llega?");
        for(int i = 0; i < barcosEntrantes.size(); i++){
            System.out.println(barcosEntrantes.get(i).getNombre() + " con capacidad de " + barcosEntrantes.get(i).getTamano() + " metros");
        }

        System.out.println("Barcos ordenados por capacidad: ");

        //asignar amarre a barco y borrar barco de la lista de barcos entrantes
        for(int i = 0; i < barcosEntrantes.size(); i++){
            for(int j = 0; j < listPantalan.size(); j++){
                for(int x = 0; x < listPantalan.get(j).getListAmarre().size(); x++){
                    if(barcosEntrantes.get(i).getTamano() <= listPantalan.get(j).getListAmarre().get(x).getTamanoAmarre() && !listPantalan.get(j).getListAmarre().get(j).isOcupado()){
                        listPantalan.get(j).getListAmarre().get(x).setOcupado(true);
                        
                        listPantalan.get(j).getListAmarre().get(x).setBarco(barcosEntrantes.get(i));
                        barcosEntrantes.remove(i);
                    }
                }
            }
        }

        for (int i = 0; i < barcosEntrantes.size(); i++) {
            for (int j = 0; j < listPantalan.size(); j++) {
            }
        }
    }

    public static void verAmarre(ArrayList<Pantalan> listPantalan){
        for (int i = 0; i < listPantalan.size(); i++) {
            System.out.println("Pantalán " + listPantalan.get(i).getId() + " con capacidad de " + listPantalan.get(i).getListAmarre().get(i).getTamanoAmarre() + " metros");
        }
    }

    /*public static void simular(ArrayList<Pantalan> listPantalan){
        for (int i = 0; i < listPantalan.size(); i++) {
            if (listPantalan.get(i).getListAmarre().get(i).isOcupado()) {
                System.out.println("El pantalán " + listPantalan.get(i).getNombre() + " está ocupado por el barco " + listPantalan.get(i).getBarco().getNombre());
            } else {
                System.out.println("El pantalán " + listPantalan.get(i).getNombre() + " está libre");
            }
        }
    }*/

    //main

    public static void main (String [] args)throws IOException {
        Pantalan pantalan1 = new Pantalan(1, Pantalan.listAmarre, "comercial");
        listPantalan.add(pantalan1);
        Pantalan pantalan2 = new Pantalan(2, Pantalan.listAmarre, "recreo");
        listPantalan.add(pantalan2);
        Amarre amarre1 = new Amarre(200, false, null);
        Pantalan.listAmarre.add(amarre1);
        Amarre amarre2 = new Amarre(100, false, null);
        Pantalan.listAmarre.add(amarre2);
        Amarre amarre3 = new Amarre(300, false, null);
        Pantalan.listAmarre.add(amarre3);
        Amarre amarre4 = new Amarre(50, false, null);
        Pantalan.listAmarre.add(amarre4);

        
        System.out.println("Bienvenido al puerto de Barcelona");
        System.out.println("¿Qué desea hacer?");
        System.out.println("Cargando barcos...");
        Barco.cargarBarcosEntrantes(barcosEntrantes);
        System.out.println("Cargando pantalanes...");
        verAmarre(listPantalan);
        System.out.println("Busqueda de amarre...");
        buscarAmarre(barcosEntrantes, listPantalan);
    }   
}
