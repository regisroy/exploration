# Survol de JUnit5

[Site de JUnit5](http://junit.org/junit5)


## Qu'y a t-il de nouveau ?

- dépendance **`org.junit.jupiter.api`** au lieu de `org.junit`
    - ex: **org.junit.jupiter:junit-jupiter-api:5.0.0-M2**


## Quelques changements

- **`@BeforeEach`, `@BeforeAll`, `@AfterEach`, `@AfterAll`**      
   au lieu de `@Before` `@After` `@BeforeTest` `@AfterTest`
- **`@Disabled`** au lieu de `@Ignored`
- **`@ExtendedWith`** remplace `@RunWith` et `@Rule`
- **`DynamicTests`** remplace les tests `Parameterized`
- **`Assertions#expectThrows`** pour les exceptions attendues
- Changer le nom affiché du Test **`@DisplayName`**
- Faire des tests imbiqués **`@Nested`**



## Quelques exemples

- Test simple "hello"
    - `codons`
- Test avec `@DisplayName`
    - `codons`
- Test quand "h"
    - `codons`
- Test quand ""
    - `codons`
- Plusieurs tests pour cas "Quand il y a une chaine de caractères", pourquoi pas tout dans le même test.
    - cas 1 : plusieurs appels => bof bof
    - cas 2 : on joue plusieurs fois le même test
        - avant : Remplacement de `Parametrized` (le test avec des paramètres différents) => compliqué
        - maintenant : avec JUnit 5 et `@TestFactory`    
          => `codons`
- **Test d'une exception**
    - avant c'était directement sur l'annotation     
       => donc un test à chaque fois     
       => 1 exception, peut devenir rapidement lourd quand plusieurs
    - ensuite comment faire pour tester le message de l'exception ?
    - maintenant : `expectThrows`    
      => `codons`
- Ensuite je travaille avec **des objets plus complexes**
    - j'aimerai être capable de tester que l'objet retourné existe mais aussi les valeurs de ses attributs     
        - `assertAll()`    
           => `codons`
- Notion de `@Tag` : @Tag("integration") : catégoriser et filtrer
    - avant on pouvait utiliser `Category`
    - maintenant : `Tag`
        - simple    
          => `codons`
        - un peu plus clair et réutilisable    
          => `codons`
- Les extensions 
    - Remplacement de `@Rule` et `@RunWith`: exemple cas où une ressource est dispo après le démarrage
    - maintenant : `@ExtendWith`
- Les Nested tests avec `@Nested`
- injection de Meta données
    - `TestInfo`
    - `TestReporter`
- Avoir des conditions d'execution des tests
- revue des assomptions avec les lambdas
- utilisation des Default methods dans les interfaces
- Run test en ligne de commande 
```    
# run all tests
junit-platform-console -p ${path_to_compiled_test_classes} -a
# run a specific test
junit-platform-console
    -p ${path_to_compiled_test_classes}
    org.infoq.junit5.HelloWorldTest    
```
.    
.    
.    
.    
.     
.    
.     
.    
.    
https://github.com/rherrmann/junit5-experiments/tree/master/src/test/java/com/codeaffine/junit5



