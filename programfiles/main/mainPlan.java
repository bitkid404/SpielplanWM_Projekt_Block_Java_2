package programfiles.main;
import programfiles.view.View;
import database.DatabaseConnector;

public class MainPlan {

    public static void main(String[] args) {
        View view = new View();
        view.displayMessage("Welcome to the World Cup 2026 Management System!");
        view.displayMessage("This system allows you to manage matches and teams.");
        view.displayMessage("This Teams are currently in the database:");
        //Erstellt ein neues Datenbankobjekt und fügt alle eingetragenen Teams
        //aus der Datenbank in eine Liste und sendet diese an das View Textfeld.
        DatabaseConnector viewdbConnector = new DatabaseConnector();
        String liste = viewdbConnector.getTeams();
        view.displayMessage(liste);}
    }