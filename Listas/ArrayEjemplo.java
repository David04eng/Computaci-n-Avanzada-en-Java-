package Listas;

import java.util.ArrayList;

public class ArrayEjemplo {

    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<>();

        nombres.add("Ana");
        nombres.add("Luis");
        nombres.add("Carlos");
        nombres.add("María");
        nombres.add("Sofía");

        System.out.println("Lista de nombres:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        System.out.println("Cantidad de nombres: " + nombres.size());
    }
}