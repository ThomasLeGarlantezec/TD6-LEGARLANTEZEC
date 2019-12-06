package com.company;

import edu.princeton.cs.introcs.StdDraw;

public class TestMove1 {
    public final static int X_MAX = 64;
    public final static int Y_MAX = 24;
    public final static float WIDTH = 0.5f;

    public static void main(String[] args) {
        // Défini l'espace de représentation (visible à l'écran)
        StdDraw.setXscale(-WIDTH, X_MAX + WIDTH);
        StdDraw.setYscale(-WIDTH, Y_MAX + WIDTH);
        for (int y = Y_MAX; y >= 0; --y) {
            for (int x = 0; x <= X_MAX; ++x) {
                // Efface l'ecran et le colore en gris
                StdDraw.clear(StdDraw.GRAY);
                // Définit la couleur d'affichage actuelle comme rouge
                StdDraw.setPenColor(StdDraw.RED);
                // Dessine un disque de rayon WIDTH aux coordonnées x,y indiquées.
                StdDraw.filledCircle(x, y, WIDTH);
                // Affiche le dessin et pause pendant 20ms
                StdDraw.show(20);
            }
        }
    }
}