Meta:

Narrative:
En tant que utilisateur
Je veux acheter des livres de Harry Potter
Ainsi je vais pouvoir fournir tout l'immeuble, et ensuite la ville entière

Scenario: Calculer le prix de livres différents de Harry Potter
Given Je vais au magasin
When J'achète <nbtome1> livres tome 1
Then la réduction est de <reduction> %
Then Je paie <prixtotal> euros

Examples:
|nbtome1|prixtotal|reduction|
|1|0|0|0|0|8|0|



