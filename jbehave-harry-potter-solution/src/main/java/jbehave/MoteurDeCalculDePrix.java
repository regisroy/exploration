package jbehave;

import java.util.HashMap;
import java.util.Map;

public class MoteurDeCalculDePrix {

    private static final int PRICE_ONE_BOOK = 8;
    private Map<String, Integer> nbLibreByTome = new HashMap<>();

    public void buyBook(int nbLivre, String tome) {
        nbLibreByTome.put(tome, nbLivre);
    }

    public double compute() {
        return (PRICE_ONE_BOOK * getNbLivre()) * (1.0 - (computeDiscount() / 100.0));
    }

    private int getNbLivre() {
        int nbLivres = 0;
        for (Integer nbLivre : nbLibreByTome.values()) {
            nbLivres += nbLivre;
        }
        return nbLivres;
    }

    private int computeDiscount() {
        int size = nbLibreByTome.size();
        int discount = 0;

        if (size == 1)
            discount = 0;
        if (size == 2)
            discount = 5;
        if (size == 3)
            discount = 10;
        if (size == 4)
            discount = 20;
        if (size == 5)
            discount = 25;

        return discount;
    }

    public int discount() {
        return computeDiscount();
    }

}
