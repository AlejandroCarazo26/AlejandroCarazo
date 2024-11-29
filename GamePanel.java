package GUI;

import Personajes.Apple;
import Personajes.AppleFactory;
import Personajes.Character;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener {
    private Personajes.Character character;
    private ArrayList<Apple> apples;

    public GamePanel(int numApples) {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);

        character = new Character(50, 50);

        // Usar la fábrica para crear manzanas según la dificultad
        apples = AppleFactory.createApples(numApples);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                randomApplePos(); // Randomizar posiciones cuando se ajusta el tamaño
            }
        });
    }

    private void checkCollision() {
        apples.removeIf(apple -> character.getBounds().intersects(apple.getBounds()));
    }

    public void randomApplePos() {
        Random rand = new Random();
        int pWidth = this.getWidth();
        int pHeight = this.getHeight();
        int appleSize = 15;

        for (Apple apple : apples) {
            int x = rand.nextInt(pWidth - appleSize);
            int y = rand.nextInt(pHeight - appleSize);
            apple.setPosition(x, y);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        character.draw(g);
        for (Apple apple : apples) {
            apple.draw(g);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        character.keyPressed(e);
        updateGameState();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        character.keyReleased(e);
        updateGameState();
    }

    private void updateGameState() {
        character.move();
        checkCollision();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}