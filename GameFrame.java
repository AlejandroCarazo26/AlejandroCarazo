package GUI;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;

    public GameFrame(int numApples) {
        gamePanel = new GamePanel(numApples);  // Inicializa con el número de manzanas
        this.add(gamePanel);
        this.setTitle("Juego de Manzanas");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}