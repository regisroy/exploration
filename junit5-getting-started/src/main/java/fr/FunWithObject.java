package fr;

public class FunWithObject {

    public Maison getMaison(final String stringWithCommas) {
        String[] tableau = stringWithCommas.split(";");

        return new Maison(tableau[0], tableau[1], tableau[2]);
    }
}
