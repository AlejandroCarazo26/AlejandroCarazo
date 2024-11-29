package GUI;

import javax.swing.*;

public class MainGame {
    public static void main(String[] args) {
        JFrame ventanaInicial = crearVentana("Selecciona Dificultad");

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(null);

        JButton B1 = new JButton("Fácil");
        JButton B2 = new JButton("Medio");
        JButton B3 = new JButton("Difícil");
        JLabel texto = new JLabel("Cuando empiece el juego, pulse para iniciar");

        B1.setBounds(100, 150, 100, 100);
        B2.setBounds(200, 150, 100, 100);
        B3.setBounds(300, 150, 100, 100);
        texto.setBounds(125,25,450,50);

        panelBotones.add(B1);
        panelBotones.add(B2);
        panelBotones.add(B3);
        panelBotones.add(texto);

        ventanaInicial.add(panelBotones);
        ventanaInicial.setVisible(true);

        // Listeners con diferentes dificultades
        B1.addActionListener(e -> abrirJuegoConDificultad(ventanaInicial, 5));  // Fácil: 5 manzanas
        B2.addActionListener(e -> abrirJuegoConDificultad(ventanaInicial, 10)); // Medio: 10 manzanas
        B3.addActionListener(e -> abrirJuegoConDificultad(ventanaInicial, 15)); // Difícil: 15 manzanas
    }

    private static JFrame crearVentana(String titulo) {
        JFrame ventana = new JFrame(titulo);
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        return ventana;
    }

    private static void abrirJuegoConDificultad(JFrame ventanaInicial, int numApples) {
        ventanaInicial.dispose();
        new GameFrame(numApples);
    }
}