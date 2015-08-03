package jbehave;

import org.jbehave.core.annotations.*;
import org.jbehave.core.model.ExamplesTable;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class KataPotterStep {

    private MoteurDeCalculDePrix moteurDeCalculDePrix;

    @Given("Je vais au magasin")
    public void jeVaisAuMagasin() {
        moteurDeCalculDePrix = new MoteurDeCalculDePrix();
    }

    @When("J'achète $nbLivre livre tome $tome")
    @Alias("J'achète $nbLivre livres tome $tome")
    public void ajouterDesLivresDifferents(int nbLivre, String tome) {
        moteurDeCalculDePrix.buyBook(nbLivre, tome);
    }

    @When("J'achète des livres: $achats")
    public void achetedesLivres(ExamplesTable achats) {
        List<Map<String, String>> rows = achats.getRows();
        for (Map<String, String> row : rows) {
            moteurDeCalculDePrix.buyBook(Integer.valueOf(row.get("quantite")), row.get("tome"));
        }
    }

    @Then("la réduction est de $discount %")
    public void laReductionEstDe(int discount) {
        int priceActual = moteurDeCalculDePrix.discount();
        assertThat(priceActual).isEqualTo(discount);
    }

    @Then("Je paie $prix euros")
    public void jePaie(double expectedPrice) {
        double priceActual = moteurDeCalculDePrix.compute();
        assertThat(priceActual).isEqualTo(expectedPrice);
    }

}
