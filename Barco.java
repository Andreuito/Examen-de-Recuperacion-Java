package Navios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public abstract class Barco {
    private String matricula;
    private String nombre;
    private float tamano;

    // getters i setters

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTamano() {
        return tamano;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }

    // constructores

    public Barco() {
        this.matricula = "";
        this.nombre = "";
        this.tamano = 0;
    }

    public Barco(String matricula, String nombre, float tamano) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.tamano = tamano;
    }

    // metodos

    public static String mayorTamano(ArrayList<Barco> barcosEntrantes) {
        float tamano = 0;
        String resultado = "";
        tamano = barcosEntrantes.get(0).getTamano();

        for (int i = 0 ; i < barcosEntrantes.size(); i++ ){
            if (tamano < barcosEntrantes.get(i).getTamano()){
                tamano = barcosEntrantes.get(i).getTamano();
                resultado = barcosEntrantes.get(i).getMatricula();
            }   
        }

        for(int x = 0; x < barcosEntrantes.size(); x++){
            if (resultado.equals(barcosEntrantes.get(x).getMatricula())){
                System.out.println("El barco de mayor tamaño es: " + barcosEntrantes.get(x).getMatricula());
            }
        }
        return resultado;
    }
    

    public boolean encajaTipo(Pantalan pantalan) {
        Scanner teclado = new Scanner(System.in);
        int opcion = teclado.nextInt();
        boolean resultado = false;
        if (pantalan.getTipo().equals("Comercial")){
            if (pantalan.getListAmarre().get(opcion).getBarco().getClass().equals("Comercial.java")){
                resultado = true;
            }
        }
        if (pantalan.getTipo().equals("Recreo")){
            if (pantalan.getListAmarre().get(opcion).getBarco().getClass().equals("Recreo.java")){
                resultado = true;
            }
        }
        return resultado;
    }

    public float encajaTamano(Amarre amarre) {
        float resultado = 0;
        if (amarre.getBarco().getTamano() <= amarre.getTamanoAmarre()){
            resultado = amarre.getTamanoAmarre() - amarre.getBarco().getTamano();
        }
        return resultado;
    }

    public static void cargarBarcosEntrantes(ArrayList<Barco> barcosEntrantes) throws IOException {
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(
                    Paths.get("C:\\Users\\Andreu\\Documents\\Clase\\Programació\\Java\\Navios\\barcos.txt")));
            for (int i = 0; i < lines.size(); i++) {
                String[] datos = lines.get(i).split(";");
                if (datos[0].equals("Comercial")) {
                    Comercial comercial = new Comercial(datos[1], datos[2], Float.parseFloat(datos[3]), "0");
                    barcosEntrantes.add(comercial);
                }
                if (datos[0].equals("Recreo")) {
                    Recreo recreo = new Recreo(datos[1], datos[2], Float.parseFloat(datos[3]), "0");
                    barcosEntrantes.add(recreo);
                }
            }

            for(int x = 0; x < barcosEntrantes.size(); x++){
                System.out.println(barcosEntrantes.get(x)+ " Matricula: " + barcosEntrantes.get(x).getMatricula()+"," + "  Nombre: " + barcosEntrantes.get(x).getNombre() +"," + "  Tamaño: " + barcosEntrantes.get(x).getTamano()+ "}");
            }

            

            
            System.out.println("Barcos cargados");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public String toString() {
        return "Barco{" + "matricula=" + matricula + ", nombre=" + nombre + ", tamano=" + tamano + '}';
    }
}
