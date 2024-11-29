package Personajes;

/*

- JavaDocs para Character
- Foto en el menu incial

 */

/**
 * En la clase Apple va a tener dos varibles x y para determinar la posicion de estas
 * En el metodo setPosition vas a setear las posiciones
 * En la funcion draw vas a dibujar las manzanas de color rojo, despues utilizas el metoddo fill para rellenar de ese color las manzanas e indicar el tama&ntilde;o
 * En la funcion getBounds vas a devolver el rectangulo en las posiciones del set, con las dimensiones indicadas
 */

import java.awt.*;

public class Apple {
    private int x, y;
    //Constructor de la clase
    public Apple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //seteas la posicion
    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    //Das color y lo rellenas para que la manzana sea visible
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x, y, 15, 15);
    }
    //devuelve el rectangulo para dibujarlo
    public Rectangle getBounds() {
        return new Rectangle(x, y, 15, 15);
    }
}