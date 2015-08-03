package jbehave;

import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HarryPotterSteps {


    private Basket basket;

    @Given("Le panier est vide")
    public void panierVide() {
        basket = new Basket();
    }

    @When("j'ajoute $nbLivre livre dans le panier")
    @Aliases(values={
            "j'ajoute $nbLivre livres différents dans le panier",
    })
    public void ajoutDeLivreDansLePanier(int nbLivre) {
        basket.addBook(nbLivre);
    }
    @When("j'ajoute $nbLivre livres identiques")
    public void ajoutDeLivreIdentiquesDansLePanier(int nbLivre) {
        basket.addBookIdentical(nbLivre);
    }

    @When("j'ajoute: $achats")
    public void add(ExamplesTable ajouts) {
        List<Map<String, String>> rows = ajouts.getRows();
        for (Map<String, String> row : rows) {
            basket.addBook(row.get("tome"), Integer.valueOf(row.get("quantite")));
        }

    }

    @Then("je vais payer $prix euros")
    public void resultat(double prix) {
        assertThat(basket.getPrice()).isEqualTo(prix);
    }


}
