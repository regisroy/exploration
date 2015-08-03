package backup;

import java.util.HashMap;
import java.util.Map;

public class MoteurDeCalculDePrixV1 {

    private static final int PRICE_ONE_BOOK = 8;
    private int discount = 0;
    private int nbLivre;
    private Map<String, Integer> nbLibreByTome = new HashMap<>();

    public void buyBook(int nbLivre, String tome) {
        this.nbLivre = nbLivre;
        nbLibreByTome.put(tome, nbLivre);
    }

    public double compute() {
        computeDiscount();
        return (PRICE_ONE_BOOK * getNbLivre()) * (1.0 - (discount / 100.0));
    }

    private int getNbLivre() {
        int nbLivres = 0;
        for (Integer nbLivre : nbLibreByTome.values()) {
            nbLivres += nbLivre;
        }
        return nbLivres;
    }

    private void computeDiscount() {
        int size = nbLibreByTome.size();

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
    }

    public int discount() {
        return discount;
    }

    public void buyBookV1(int nbLivre) {
        this.nbLivre = nbLivre;
        if (this.nbLivre == 1)
            discount = 0;
        if (this.nbLivre == 2)
            discount = 5;
        if (this.nbLivre == 3)
            discount = 10;
        if (this.nbLivre == 4)
            discount = 20;
        if (this.nbLivre == 5)
            discount = 25;
    }
}
