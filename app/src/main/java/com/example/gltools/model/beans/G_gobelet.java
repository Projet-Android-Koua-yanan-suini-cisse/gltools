package com.example.gltools.model.beans;;

public class G_gobelet {
    private D_de.De de1, de2;

    public G_gobelet() {
        de1 = new D_de.De();
        de2 = new D_de.De();
    }

    public void lancer() {
        de1.lancer();
        de2.lancer();
    }

    public int getScoreDes() {
        return de1.getValeur() + de2.getValeur();
    }

    /********************
     * GETTER/SETTER
     *****************/

    public D_de.De getDe1() {
        return de1;
    }

    public D_de.De getDe2() {
        return de2;
    }
}
