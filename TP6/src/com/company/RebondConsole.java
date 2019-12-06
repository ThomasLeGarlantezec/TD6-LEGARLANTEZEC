package com.company;

import edu.princeton.cs.introcs.StdDraw;

public class RebondConsole {
    public final static int X_MAX = 100;
    public final static int Y_MAX = 100;
    public final static float WIDTH = 0.5f;

    public static void main(String[] args) {
        float vitesseVerticale = 0.0f;
        float x = 0.0f;
        float y = 100.0f;
        float verticale = 0.0f;
        float horizontale = 6.0f;
        int sense = 1;
        Balle test = new Balle(x,y,verticale,horizontale,1);
        while (0 <= test.getY() & 0 <= test.getVitesseVerticale()){
            if (test.getY() - test.getVitesseVerticale()*0.02f < 0 & test.getSense() != 0) { test.setSense(0); }
            if (test.getVitesseVerticale() - 9.81f*0.02f < 0 & test.getSense() != 1){ test.setSense(1); }
            if (test.getX() + test.getVitesseHorizontale()*0.02f > 100 || test.getX() + test.getVitesseHorizontale()*0.02f < 0) { test.setVitesseHorizontale(-test.getVitesseHorizontale()); }
            System.out.println("ordonné : " + test.getY() + " vitesseVerticale : " + test.getVitesseVerticale() + " sense : " + test.getSense());
            test.setVitesseVerticale(Balle.NewVitesseVAvecInit(test.getVitesseVerticale(),test.getSense()));
            test.setY(Balle.NewOrdonnéAvecInit(test.getY(),test.getVitesseVerticale(),test.getSense()));
            test.setX(Balle.NewAbscisseAvecInit(test.getX(),test.getVitesseHorizontale()));
        }
    }
}