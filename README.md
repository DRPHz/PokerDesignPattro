Wij (Tigo de Rijk, Damian de Ruijter) hebben voor dit project gedaan aan pair programming, we hebben zo samen dit project op 1 laptop gedaan.

De 6 design patterns die wij hebben toegevoegd zijn de volgende:

Creational:
1 Simpleton
2

Structural:
1
2

Behavioral:
1
2


Dan nu onze implementatie uitgelegd van deze patterns

Singleton:  Nou een simpleton zorgt er voor dat een class maar een instantie heeft in het hele programma en zorgt dat alles er toegang tot heeft. Bij ons is dit private Deck instance;
Het is private zodat andere classes geen nieuwe kunnen maken zodat er maar 1 bestaat.
getInstance() is een public static method die toegang geeft tot deze unieke instance van deck.

