Wij (Tigo de Rijk, Damian de Ruijter) hebben voor dit project gedaan aan pair programming, we hebben zo samen dit project op 1 laptop gedaan.

De 6 design patterns die wij hebben toegevoegd zijn de volgende:

Creational:
1 Simpleton
2 Factory Method

Structural:
1 Composite Pattern
2 Decorator Pattern

Behavioral:
1 Strategy Pattern
2 Observer Pattern


Dan nu onze implementatie uitgelegd van deze patterns

Singleton:  Nou een simpleton zorgt er voor dat een class maar een instantie heeft in het hele programma en zorgt dat alles er toegang tot heeft. Bij ons is dit private Deck instance;
Het is private zodat andere classes geen nieuwe kunnen maken zodat er maar 1 bestaat.
getInstance() is een public static method die toegang geeft tot deze unieke instance van deck.

Factory Method:  Factory zorgt er voor dat je een interface hebt voor het maken van objecten, maar de subclasses kunnen ieder een specifieke implementatie van die objecten bepalen.
Onze factory maakt players met createPlayer(), de subclasses HumanPlayerFactory en AIPlayerFactory implementeren deze methode op een specifieke manier voor die speler type.
Met de factory method verwijderen we wat complexiteit van het maken van spelers, en verminderen we code duplicatie



Strategy Pattern: Het Strategy patroon maakt het mogelijk om verschillende algoritmes te bepalen en deze op een dynamische manier in de applicatie te gebruiken. In ons geval wordt dit gebruikt door de AIPlayer, die een variabele heeft die het huidige strategie object, zoals DefensiveStrategy bevat. Dit zorgt ervoor dat de AI zich op verschillende manieren kan gedragen afhankelijk van de gekozen strategie. Dit patroon zorgt voor meer flexibiliteit en onderhoudbaarheid, omdat je nieuwe strategieën kunt toevoegen zonder de bestaande code in de AIPlayer klasse te wijzigen. Ook vermindert dit code duplicatie voor als je nieuwe strategien wilt maken.
De keuze voor een strategie kan verandert per situatie (zoals de huidige speelronde of hoe goed je hand is).


