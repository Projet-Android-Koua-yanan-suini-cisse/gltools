package com.example.gltools.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.gltools.R;
import com.example.gltools.model.beans.AmisBean;
import com.example.gltools.model.beans.ParentBean;
import com.example.gltools.model.beans.PersonneBean;

public class PersonneAdapter extends RecyclerView.Adapter<PersonneAdapter.ViewHolder> {
    private ArrayList<PersonneBean> personnes;
    private int couleurEleve, couleurEnseignant;

    //Pointeur vers une classe qui implémente OnPersonneListener
    private OnPersonneListener onPersonneListener;


    public PersonneAdapter(ArrayList<PersonneBean> personnes, OnPersonneListener onPersonneListener) {
        this.personnes = personnes;
        this.onPersonneListener = onPersonneListener;
    }


    /**
     * Méthode qui permet de créer une ligne mais que nous n'appellerons jamais nous-mêmes
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_personne, parent, false);
        couleurEleve = ContextCompat.getColor(parent.getContext(), R.color.colorPrimaryDark);
        couleurEnseignant = ContextCompat.getColor(parent.getContext(), R.color.colorAccent);

        return new PersonneAdapter.ViewHolder(view);
    }

    /**
     * Méthode qui remplit une ligne créée mais que nous n'appellerons jamais nous-mêmes
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final PersonneBean personneBean = personnes.get(position);

        holder.tv_nom.setText(personneBean.getNom());
        holder.tv_prenom.setText(personneBean.getPrenom());

        if (personneBean instanceof AmisBean) {
            holder.tv_section.setText(((AmisBean) personneBean).getClasse());
            holder.tv_nom.setTextColor(couleurEleve);
            holder.tv_prenom.setTextColor(couleurEleve);


        } else if (personneBean instanceof ParentBean) {
            holder.tv_section.setText(((ParentBean) personneBean).getMatiere());
            holder.tv_nom.setTextColor(couleurEnseignant);
            holder.tv_prenom.setTextColor(couleurEnseignant);
        }

        personneBean.setAge(10);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onPersonneListener != null) {
                    onPersonneListener.onClick(personneBean);
                }
            }
        });
    }

    /**
     * Méthode qui indique le nombre de lignes à créer mais que nous n'appellerons jamais nous-mêmes
     */
    @Override
    public int getItemCount() {
        return personnes.size();
    }

    /**
     * Classe interne représentant les pointeurs vers les composants graphiques d'une ligne de la liste
     * Il y aura une instance de cette classe par ligne
     */
    protected class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_nom, tv_prenom, tv_section;
        public View root;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_nom = (TextView) itemView.findViewById(R.id.tv_nom);
            tv_prenom = (TextView) itemView.findViewById(R.id.tv_prenom);
            tv_section = (TextView) itemView.findViewById(R.id.tv_section);
            root = itemView.findViewById(R.id.root);
        }
    }

    //Notre moyen de communication
    public interface OnPersonneListener {

        void onClick(PersonneBean personneBean);

    }
}
