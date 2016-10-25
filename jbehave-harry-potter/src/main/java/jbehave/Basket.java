package jbehave;

import java.util.HashMap;
import java.util.Map;

public class Basket {

	private double price = 8.0;
	private int nbLivre;
	private double discount = 1;
	private Map<String, Integer> livreByTome = new HashMap<>();

	public void addBook(int nbLivre) {
		this.nbLivre = nbLivre;
		discount = 1;
		if (nbLivre == 2) {
			discount = 0.95;
		}
		if (nbLivre == 3) {
			discount = 0.90;
		}
		if (nbLivre == 4) {
			discount = 0.80;
		}
		if (nbLivre == 5) {
			discount = 0.75;
		}
	}

	public double getPrice() {
		return discount * (getNbLivre() * price);
	}

	private int getNbLivre() {
		if (livreByTome.isEmpty()) {
			return nbLivre;
		}
		return livreByTome.get("1");
	}

	public void addBook(String tome, Integer quantite) {
		livreByTome.put(tome, quantite);
	}

	public void addBookIdentical(int nbLivre) {
		livreByTome.put("1", nbLivre);
	}
}
