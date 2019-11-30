package com.example.gltools.controlleur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.gltools.R;
import com.example.gltools.model.beans.AmisBean;
import com.example.gltools.model.beans.ParentBean;
import com.example.gltools.model.beans.PersonneBean;
import com.example.gltools.view.PersonneAdapter;

public class MainAnnuaire extends AppCompatActivity implements View.OnClickListener, PersonneAdapter.OnPersonneListener {
    //Composants graphiques
    Button bt_ajouter, bt_supp_dernier;
    Button bt_ajouter_plusieurs;
    EditText et_nom, et_prenom;
    SeekBar sb;
    RadioButton rb_parent, rb_ami;
    RecyclerView rv;

    //Données
    ArrayList<PersonneBean> personnes;

    //Outil
    PersonneAdapter personneAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Indique le fichier XML à charger
        setContentView(R.layout.activity_annaire);

        //Récupère les éléments définis dant le fichier XML transmis à setContentView
        //tv_console = (TextView) findViewById(R.id.tv_console);
        bt_ajouter = (Button) findViewById(R.id.bt_ajouter);
        bt_supp_dernier = (Button) findViewById(R.id.bt_supp_dernier);
        bt_ajouter_plusieurs = (Button) findViewById(R.id.bt_ajouter_plusieurs);
        et_nom = (EditText) findViewById(R.id.et_nom);
        et_prenom = (EditText) findViewById(R.id.et_prenom);
        sb = (SeekBar) findViewById(R.id.sb);
        rb_parent = (RadioButton) findViewById(R.id.rb_parent);
        rb_ami = (RadioButton) findViewById(R.id.rb_ami);
        rv = (RecyclerView) findViewById(R.id.rv);

        //Redirige le clic sur le bouton sur la méthode OnClick
        bt_ajouter.setOnClickListener(this);
        bt_supp_dernier.setOnClickListener(this);
        bt_ajouter_plusieurs.setOnClickListener(this);

        //Création d'une collection d'élèves
        personnes = new ArrayList<>();

        //Création de l'adapter qui utilisera notre liste
        personneAdapter = new PersonneAdapter(personnes, this);

        //On demande au RecycleView d'utiliser notre adapter
        rv.setAdapter(personneAdapter);

        //Réglage d'affichage du recyclerView
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    /**
     * Méthode qui sera appelée lors d'un clic sur le bouton
     */
    public void onClick(View v) {

        if (v == bt_ajouter) {
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouter(nom, prenom, 1);

        } else if (v == bt_supp_dernier) {
            supprimerDernier();
        } else if (v == bt_ajouter_plusieurs) {
            int nb = sb.getProgress();
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouter(nom, prenom, nb);
        }

    }

    /**
     * Ajoute un ensemble de parents ou d'amis
     */
    public void ajouter(String nom, String prenom, int nb) {

        if (nom.length() == 0) {
            Toast.makeText(this, "Le nom et le prénom sont vides", Toast.LENGTH_SHORT).show();
            return;
        }
        if (prenom.length() == 0) {
            Toast.makeText(this, "Le Numéro est vide", Toast.LENGTH_SHORT).show();
            return;
        }


        for (int i = 0; i < nb; i++) {
            if (rb_parent.isChecked()) {
                //Création d'un parent
                //Je lui donne un nom et un prénom
                AmisBean parent = new AmisBean(nom, prenom, "Parents");
                //Je l'ajoute à la liste
                personnes.add(parent);
            } else {
                ParentBean parentBean = new ParentBean(nom, prenom, "Amis");
                personnes.add(parentBean);
            }
        }

        //On notifie notre adapter que les données ont changé
        personneAdapter.notifyDataSetChanged();

    }


    public void supprimerDernier() {

        PersonneBean dernier = null;


        for (PersonneBean personneBean : personnes) {
            if (rb_parent.isChecked() && personneBean instanceof AmisBean) {
                //Dans la liste de personnes, on cherche le dernier parent
                dernier = personneBean;
            } else if (rb_ami.isChecked() && personneBean instanceof ParentBean) {
                //Dans la liste de personnes, on cherche le dernier amis
                dernier = personneBean;
            }
        }

        if (dernier != null) {
            personnes.remove(dernier);
        } else if (rb_parent.isChecked()) {
            Toast.makeText(this, "Il n'y a plus de parent dans la liste", Toast.LENGTH_SHORT).show();
        } else if (rb_ami.isChecked()) {
            Toast.makeText(this, "Il n'y a plus d'amis dans la liste", Toast.LENGTH_SHORT).show();
        }

        //On notifie notre adapter que les données ont changé
        personneAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(PersonneBean personneBean) {
        Toast.makeText(this, "Vous avez cliquez sur " + personneBean.getNom() + " " + personneBean.getPrenom(), Toast.LENGTH_SHORT).show();

    }
}
