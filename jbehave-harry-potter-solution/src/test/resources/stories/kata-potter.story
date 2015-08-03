Meta:

Narrative:
En tant que utilisateur
Je veux acheter des livres de Harry Potter
Ainsi je vais pouvoir fournir tout l'immeuble, et ensuite la ville entière

Scenario: Calculer le prix d'un livre de Harry Potter
Given Je vais au magasin
When J'achète 1 livre tome 1
Then Je paie 8 euros
Then la réduction est de 0 %

Scenario: Calculer le prix de deux livres différents de Harry Potter
Given Je vais au magasin
When J'achète 1 livre tome 1
When J'achète 1 livre tome 2
Then la réduction est de 5 %
Then Je paie 15.2 euros

Scenario: Calculer le prix de trois livres différents de Harry Potter
Given Je vais au magasin
When J'achète 1 livre tome 1
When J'achète 1 livre tome 2
When J'achète 1 livre tome 3
Then la réduction est de 10 %
Then Je paie 21.6 euros

Scenario: Calculer le prix de quatre livres différents de Harry Potter
Given Je vais au magasin
When J'achète 1 livre tome 1
When J'achète 1 livre tome 2
When J'achète 1 livre tome 3
When J'achète 1 livre tome 4
Then la réduction est de 20 %
Then Je paie 25.6 euros

Scenario: Calculer le prix de cinq livres différents de Harry Potter V1
Given Je vais au magasin
When J'achète 1 livre tome 1
When J'achète 1 livre tome 2
When J'achète 1 livre tome 3
When J'achète 1 livre tome 4
When J'achète 1 livre tome 5
Then la réduction est de 25 %
Then Je paie 30 euros

Scenario: Calculer le prix de cinq livres différents de Harry Potter V2
Given Je vais au magasin
When J'achète des livres:
|quantite|tome|
|   1    |  1 |
|   1    |  2 |
|   1    |  3 |
|   1    |  4 |
|   1    |  5 |
Then la réduction est de 25 %
Then Je paie 30 euros

Scenario: Calculer le prix de 2 livre identiques de Harry Potter
Given Je vais au magasin
When J'achète 2 livres tome 3
Then la réduction est de 0 %
Then Je paie 16 euros

Scenario: Reduction sur 1 set de 3 livres et 1 set de 2 livres
Given Je vais au magasin
When J'achète 1 livres tome 1
When J'achète 2 livres tome 2
When J'achète 3 livres tome 3
Then Je paie 36.80 euros




