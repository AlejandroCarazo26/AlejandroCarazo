package Personajes;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * Declaras las varibles x y para saber la posicion del character, tambien declaramos las variables velX y velY para saber a que velocidad en medicion de pixeles se va a mover
 * La funcion move lo que haces es sumar a la posicion actual la propia velocidad y poner esa suma como la nueva posicion
 * La funcion draw utilizas el metodo setColor para poner el personaje en blanco y luego utilizamos fill para relllenar el personaje de ese color y darle dimensiones
 * La funcione keyPressed la utilizamos para reconocer la tecla que se ha apretado, reconocemos las flechas si es la de arriba, la velY sera 5, si es la de abajo, la velY sera -5, si es la de la izquierdo, la velX sera -5 y si es la de la de la derecha, la velX sera 5,
 * La funcione keyReleased la utilizamos para reconocer la tecla que se ha soltado, simplemente si la flecha de derecha o izquierda se suelta, la velX sera 0 y si la flrcha de arriba o abajo se suelta la velY sera 0
 * La funcion getBounds lo que hace es devolver el rectangulo en la posicion indicada en x y y el tamaño que queramos (20,20)
 */

public class Character {
    private int x, y;
    private int velX = 0, velY = 0;
    //constructor de character para la posicion
    public Character(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //la funcion mover
    public void move() {
        x += velX;
        y += velY;
    }
    //pintar de color blanco y settearlo en la posicion inical dandole tamaño
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 20, 20);
    }
    // detecta la tecla presionada y si es alguna flecha da valor a velocidad que se sumara restara en el eje correspondiente
    public void keyPressed(KeyEvent e) {
        //int key = e.getKeyCode();
        if (e.getKeyCode() == KeyEvent.VK_LEFT) velX = -5;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) velX = 5;
        if (e.getKeyCode() == KeyEvent.VK_UP) velY = -5;
        if (e.getKeyCode() == KeyEvent.VK_DOWN) velY = 5;
    }
    // cuando suelta la tecla del eje que sea la velocidad de ese mismo eje va a 0
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) velX = 0;
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) velY = 0;
    }
    // devuelve el rectangulo con el tamaño
    public Rectangle getBounds() {
        return new Rectangle(x, y, 20, 20);
    }
}