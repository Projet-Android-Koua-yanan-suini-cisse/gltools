package com.example.gltools.model.beans;

import java.util.Random;

public class D_de {

    /**
     * Created by booth09-mgr2 on 18/03/2017.
     */

    public static class De {

        private static final int NB_FACE = 6;
        private static final Random random = new Random();
        private int valeur;

        public void lancer() {
            valeur = random.nextInt(NB_FACE) + 1;
        }

        /********************
         * GETTER/SETTER
         *****************/

        public int getValeur() {
            return valeur;
        }
    }

}
