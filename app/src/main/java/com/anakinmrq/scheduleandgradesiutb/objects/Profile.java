package com.anakinmrq.scheduleandgradesiutb.objects;

import java.io.Serializable;

public class Profile implements Serializable {

    private String nom;
    private String prenom;
    private String numetu;

    public Profile(String nom, String prenom, String numetu) {
        this.nom = nom;
        this.prenom = prenom;
        this.numetu = numetu;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumetu() {
        return numetu;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", numetu='" + numetu + '\'' +
                '}';
    }

}
