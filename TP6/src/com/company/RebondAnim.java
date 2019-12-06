package com.company;

import edu.princeton.cs.introcs.StdDraw;
import java.util.Scanner;

public class RebondAnim {
    public final static int X_MAX = 100;
    public final static int Y_MAX = 100;
    public final static float WIDTH = 0.5f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("avec vitesse initiale(0) ou sans(1) : ");
        int choix = scanner.nextInt();
        if (choix == 1) {
            StdDraw.setXscale(-WIDTH, X_MAX + WIDTH);
            StdDraw.setYscale(-WIDTH, Y_MAX + WIDTH);
            float vitesseVerticale = 0.0f;
            float x = 50.0f;
            float y = 100.0f;
            float verticale = 0.0f;
            float horizontale = 0.0f;
            int sense = 1;
            Balle test = new Balle(x, y, verticale, horizontale, 1);
            while (0 <= test.getY() & 0 <= test.getVitesseVerticale()) {
                if (test.getY() - test.getVitesseVerticale() * 0.02f < 0 & test.getSense() != 0) { test.setSense(0); }
                if (test.getVitesseVerticale() - 9.81f * 0.02f < 0 & test.getSense() != 1) { test.setSense(1); }
                test.setVitesseVerticale(Balle.NewVitesseSansInit(test.getVitesseVerticale(), test.getSense()));
                test.setY(Balle.NewOrdonnéSansInit(test.getY(), test.getVitesseVerticale(), test.getSense()));
                // Efface l'ecran et le colore en gris
                StdDraw.clear(StdDraw.GRAY);
                // Définit la couleur d'affichage actuelle comme rouge
                StdDraw.setPenColor(StdDraw.RED);
                // Dessine un disque de rayon WIDTH aux coordonnées x,y indiquées.
                StdDraw.filledCircle(test.getX(), test.getY(), WIDTH);
                // Affiche le dessin et pause pendant 20ms
                StdDraw.show(20);
            }
        } else {
            System.out.println("rentré la vitesse initial : ");
            float horizontale = scanner.nextFloat();
            StdDraw.setXscale(-WIDTH, X_MAX + WIDTH);
            StdDraw.setYscale(-WIDTH, Y_MAX + WIDTH);
            float vitesseVerticale = 0.0f;
            float x = 0.0f;
            float y = 100.0f;
            float verticale = 0.0f;
            int sense = 1;
            Balle test = new Balle(x,y,verticale,horizontale,1);
            while (0 <= test.getY() & 0 <= test.getVitesseVerticale()) {
                if (test.getY() - test.getVitesseVerticale() * 0.02f < 0 & test.getSense() != 0) { test.setSense(0); }
                if (test.getVitesseVerticale() - 9.81f * 0.02f < 0 & test.getSense() != 1) { test.setSense(1); }
                if (test.getX() + test.getVitesseHorizontale() * 0.02f > 100 || test.getX() + test.getVitesseHorizontale() * 0.02f < 0) { test.setVitesseHorizontale(-test.getVitesseHorizontale()); }
                test.setVitesseVerticale(Balle.NewVitesseVAvecInit(test.getVitesseVerticale(), test.getSense()));
                test.setY(Balle.NewOrdonnéAvecInit(test.getY(), test.getVitesseVerticale(), test.getSense()));
                test.setX(Balle.NewAbscisseAvecInit(test.getX(), test.getVitesseHorizontale()));
                // Efface l'ecran et le colore en gris
                StdDraw.clear(StdDraw.GRAY);
                // Définit la couleur d'affichage actuelle comme rouge
                StdDraw.setPenColor(StdDraw.RED);
                // Dessine un disque de rayon WIDTH aux coordonnées x,y indiquées.
                StdDraw.filledCircle(test.getX(), test.getY(), WIDTH);
                // Affiche le dessin et pause pendant 20ms
                StdDraw.show(20);
            }
        }
    }
}
