package com.example.gltools.model.beans;

public class D_Joueur {
    private String nom;
    private int score;
    private G_gobelet gobelet;

    public D_Joueur(String nom) {
        this.nom = nom;
        gobelet = new G_gobelet();
        score = 0;
    }

    public void lancer() {
        gobelet.lancer();
    }

    public int getScoreDes() {
        return gobelet.getScoreDes();
    }

    public int getDe1() {
        return gobelet.getDe1().getValeur();
    }

    public int getDe2() {
        return gobelet.getDe2().getValeur();
    }

    /********************
     * GETTER/SETTER
     *****************/
    public String getNom() {
        return nom;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
