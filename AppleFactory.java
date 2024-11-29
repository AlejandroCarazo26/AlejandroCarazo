package Personajes;

import java.util.ArrayList;

/*
  Fábrica para crear listas de manzanas según la dificultad.
 */
public class AppleFactory {
    /*
      Crea una lista de manzanas.
     */

    public static ArrayList<Apple> createApples(int numApples) {
        ArrayList<Apple> apples = new ArrayList<>();
        for (int i = 0; i < numApples; i++) {
            apples.add(new Apple(0, 0)); // Posición inicial provisional
        }
        return apples;
    }
}

