package fr;

public class Maison {
    private String nom;
    private final String tailleM2;
    private final String nombreDePieces;

    public Maison(String nom, String tailleM2, String nombreDePieces) {
        this.nom = nom;
        this.tailleM2 = tailleM2;
        this.nombreDePieces = nombreDePieces;
    }

    public String getNom() {
        return nom;
    }

    public String getTailleM2() {
        return tailleM2;
    }

    public String getNombreDePieces() {
        return nombreDePieces;
    }
}
