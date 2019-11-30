package com.example.gltools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.example.gltools.controlleur.MainAnnuaire;


public class MainSelector extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

    }
    public void annuaire (View view) {
        startActivity(new Intent(this, MainAnnuaire.class));
    }
    public void jeu (View view) {
        startActivity(new Intent(this, MainJeu.class));
    }
    public void calco (View view) {
        startActivity(new Intent(this, MainCalculatrice.class));
    }

}
