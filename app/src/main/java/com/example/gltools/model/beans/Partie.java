package com.example.gltools.model.beans;

import com.example.gltools.model.beans.D_Joueur;

import com.example.gltools.model.beans.D_de;

public class Partie {

    public static final int NB_LANCER = 10;
    public static final int NB_A_ATTEINDRE = 7;

    private D_Joueur j1, j2;
    private int tour;
    private D_Joueur joueurSuivant;

    public Partie(String nomJ1, String nomJ2) {
        j1 = new D_Joueur(nomJ1);
        j2 = new D_Joueur(nomJ2);
        joueurSuivant = j1;
        tour = 1;
    }

    public void changerJoueur() {
        if (joueurSuivant == j1) {
            joueurSuivant = j2;
        }
        else {
            joueurSuivant = j1;
        }
    }

    /* ---------------------------------
    // Getter/Setter
    // -------------------------------- */

    public D_Joueur getJ1() {
        return j1;
    }

    public D_Joueur getJ2() {
        return j2;
    }

    public int getTour() {
        return tour;
    }

    public void setTour(int tour) {
        this.tour = tour;
    }

    public D_Joueur getJoueurSuivant() {
        return joueurSuivant;
    }
}
