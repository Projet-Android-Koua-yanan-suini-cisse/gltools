package com.example.gltools.model.beans;

public class ParentBean extends PersonneBean {
    private String matiere;


    //--------------------
    // Constructeurs
    //--------------------
    public ParentBean(String nom, String prenom) {
        super(nom, prenom);
    }


    public ParentBean(String nom, String prenom, String matiere) {
        super(nom, prenom);
        this.matiere = matiere;
    }

    //--------------------
    // Méthodes
    //--------------------

    @Override
    public String afficher() {
        return "Enseignant : " + nom + " " + prenom + " (" + matiere + ")";
    }

    //--------------------
    // Getter / Setter
    //--------------------


    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
}
