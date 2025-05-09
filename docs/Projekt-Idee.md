Projektabgabe am 25.05.2025

Projektvorgaben sind gegeben. Thema kann aber auch selber gewählt werden.
Mein Projekt:

Interaktiver Spielplan für die Fußball-WM 2026 in Kanada, USA und Mexico.
Probleme bzw. aktueller Stand: 
Es stehen noch nicht alle Teilnehmer fest. Gegeben sind nur die Spielorte
sowie das Datum des jeweiligen Spiels.(Rahmenspielplan)
Der Projektspielplan wird also eine Art "Blanko-Spielplan". 

Funktionale Anforderungen:
Der Benutzer soll Mannschaften/Nationen dem allgemeinen Team-Pool hinzufügen können.
Der User soll aus einer Liste von Nationen (Team-Pool) jeweils die passenden Nationalteams auswählen können
und diese dann den jeweiligen Gruppen zuordnen können. Diese Teams besetzen dann die vorgesehenen Startplätze.
Es sollen auch Spielergebnisse eingetragen werden können.
Aus diesen Ergebnissen soll dann automatisch eine Gruppentabelle erstellt werden.
In den KO-Phasen sollen die Sieger der Gruppen (Qualifikanten) dann automatisch in der nächsten Runde angezeigt werden (Gesetzte Partien). 
In KO-Phasen soll optional der Zusatz "Ergebnis nach Verlängerung" oder "Nach Elfmeterschießen" hinzugefügt werden können.
Die Anwendung soll über das MVC-Pattern erstellt werden. Der "View" wird durch ein passendes GUI (SWING) erstellt oder über die Kommandozeile ausgeführt werden.
Der Benutzer soll den aktuellen Spielplan abspeichern können.
Die Daten sollen in einer Datenbank (sqlite3) gespeichert werden. 

Extras wenn noch Zeit ist:
- details zum Spiel, z.B. Torschützen
- Landesflaggen hinzufügen

Nichtfunktionale Anforderungen:
Die Eingaben des Benutzers sollen plausibel sein. Bei der Ergebniseintagung wird also nur eine Ganzzahl akzeptiert.
Die Tabellenberechnung soll unmittelbar erfolgen. Da es sich um eine kleine Anwendung handelt, werden Auslastungen von CPU, RAM bzw.
Netzwerkauslastung vernachlässigt.
System muss Java-Dateien ausführen können. 
Es ist keine Benutzerauthentifikation nötig.
Keine Ahnung, was hier noch so beschrieben werden soll und ob das alles so in etwa richtig ist...