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

- Test simple
- Test avec `@DisplayName`
- Test quand null
- Test quand vide
- Remplacement de `Parametrized` (le même test avec des paramètres différents)
    - c'est compliqué à faire
- test d'une exception
    - avant c'était directement sur l'annotation     
       => donc un test à chaque fois     
       => 1 exception, peut devenir rapidement lourd quand plusieurs
    - ensuite comment faire pour tester le message de l'exception ?
- ensuite je travaille avec des objets plus complexes
    - j'aimerai être capable de tester que l'objet retourné existe mais aussi les valeurs de ses attributs
- Les extensions 
    - Remplacement de `@Rule` : exemple cas où une ressource est dispo après le démarrage
- Notion de `@Tag` : @Tag("taxes")
- Les Nested tests avec `@Nested`
- injection de Meta données
    - `TestInfo`
    - `TestReporter`
- revue des assomptions avec les lambdas
- utilisation des Default methods dans les interfaces
- 
