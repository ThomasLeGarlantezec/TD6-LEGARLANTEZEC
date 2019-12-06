package com.company;

public class Balle {
    private double x;
    private double y;
    private double vitesseVerticale;
    private double vitesseHorizontale;
    private int sense;

    public Balle(double x, double y, double vitesseVerticale, double vitesseHorizontale, int sense) {
        this.sense = 1;
        this.x = x;
        this.y = y;
        this.vitesseVerticale = vitesseVerticale;
        this.vitesseHorizontale = vitesseHorizontale;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getVitesseVerticale() {
        return vitesseVerticale;
    }

    public int getSense() {
        return sense;
    }

    public double getVitesseHorizontale() {
        return vitesseHorizontale;
    }

    public void setVitesseHorizontale(double vitesseHorizontale) {
        this.vitesseHorizontale = vitesseHorizontale;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setVitesseVerticale(double vitesseVerticale) {
        this.vitesseVerticale = vitesseVerticale;
    }

    public void setSense(int sense) {
        this.sense = sense;
    }

    public static double NewVitesseSansInit(double v,int sense){
        return newVitesse(v, sense);
    }

    public static double NewOrdonnéSansInit(double y,double v, int sense){
        double Y;
        if (sense == 1) {
            Y = y - v*0.02f;
            if (Y < 0) {
                Y = -Y;
            }
        } else {
            Y = y + v*0.02f;
        }
        return Y;
    }
    public static double NewVitesseVAvecInit(double v,int sense){
        return newVitesse(v, sense);
    }

    private static double newVitesse(double v, int sense) {
        double V;
        if (sense == 1) {
            V = v + 9.81f*0.02f;
        } else {
            V = v - 9.81f*0.02f;
            if (v <= 0) {
                V = -V;
            }
        }
        return (V-0.00282*(v*v));
    }

    public static double NewOrdonnéAvecInit(double y,double v, int sense){
        double Y;
        if (sense == 1) {
            Y = y - v*0.02f - 4.9f*0.02f;
            if (Y < 0) {
                Y = -Y;
            }
        } else {
            Y = y + v*0.02f + 4.9f*0.02f;
        }
        return Y;
    }

    public static double NewAbscisseAvecInit(double x,double v){
        double X;
        X = x + v*0.02f;
        if (X > 100) {
            X = 100 - (100 - X);
        }
        if (X < 0) {
            X = -X;
        }
        return X;
    }
}
