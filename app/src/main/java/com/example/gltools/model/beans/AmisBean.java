package com.example.gltools.model.beans;

import java.util.Random;

public class AmisBean extends PersonneBean {
    //Final pour constante
    public static final int AGE_ADULTE = 18;
    private static final Random random = new Random();

    //Attributs
    private String classe;

    //--------------------
    // Constructeurs
    //--------------------
    public AmisBean(String nom, String prenom) {
        this(nom, prenom, null);
    }

    public AmisBean(String nom, String prenom, int age) {
        this(nom, prenom, null, age);
    }

    public AmisBean(String nom, String prenom, String classe) {
        this(nom, prenom, classe, random.nextInt(100));
    }

    public AmisBean(String nom, String prenom, String classe, int age) {
        super(nom, prenom);
        this.classe = classe;
        this.age = age;
    }

    //--------------------
    // Méthodes
    //--------------------

    public boolean isAdulte() {
        return age >= AGE_ADULTE;
    }

    @Override
    public String afficher() {
        return "Amis : " + nom + " " + prenom + " (" + classe + ")";
    }

    //--------------------
    // Getter / Setter
    //--------------------

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
