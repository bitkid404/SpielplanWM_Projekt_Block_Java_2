package programfiles.view;

import database.DatabaseConnector;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
//import programfiles.control.*;

public class View {
    private JFrame frame;
    private JTextArea textArea;

    public View() {
        // Initialize the GUI components
        // Neues Fenster erstellen
        frame = new JFrame("World Cup 2026 Management System");
        // Menübar erstellen
        JMenuBar menuBar;
        //Einzelne Menüs erstellen
        JMenu menu;
        JMenu poolmenu;
        JMenu groups;
        JMenu timetable;
        //Menüpunkte erstes Menü erstellen
        JMenuItem menuItem;
        JMenuItem menuItem2;
        JMenuItem menuItem3;
        //Zweites Menü
        JMenuItem menuItemTeamadd;
        JMenuItem menuItemTeamremove;
        JMenuItem menuItemAllTeamsView;
        JMenuItem menuItemAllTeamsRemove;
        //Drittes Menü
        JMenuItem menuItemGroupA;
        JMenuItem menuItemGroupB;
        JMenuItem menuItemGroupC;
        JMenuItem menuItemGroupD;
        JMenuItem menuItemGroupE;
        JMenuItem menuItemGroupF;
        JMenuItem menuItemGroupG;
        JMenuItem menuItemGroupH;
        JMenuItem menuItemGroupI;
        JMenuItem menuItemGroupJ;
        JMenuItem menuItemGroupK;
        JMenuItem menuItemGroupL;
        //Viertes Menü
        JMenuItem menuItemTimeTableGroup;
        JMenuItem menuItemTimeTable16;
        JMenuItem menuItemTimeTable8;
        JMenuItem menuItemTimeTable4;
        JMenuItem menuItemTimeTable2;
        JMenuItem menuItemTimeTableFinale;

        // Menüleiste erstellen
        menuBar = new JMenuBar();
        menu = new JMenu("Datei");
        poolmenu = new JMenu("Teams");
        groups = new JMenu("Gruppen");
        timetable = new JMenu("Spielplan");
        // Menüeinträge erstellen
        menuItem3 = new JMenuItem("laden");
        menuItem = new JMenuItem("speichern");
        menuItem2 = new JMenuItem("beenden");
        //Zweites Menü
        menuItemTeamadd = new JMenuItem("Team hinzufügen");
        menuItemTeamremove = new JMenuItem("Team entfernen");
        menuItemAllTeamsView = new JMenuItem("Alle Teams anzeigen");
        menuItemAllTeamsRemove = new JMenuItem("Alle Teams entfernen");
        //Drittes Menü
        menuItemGroupA = new JMenuItem("Gruppe A");
        menuItemGroupB = new JMenuItem("Gruppe B");
        menuItemGroupC = new JMenuItem("Gruppe C");
        menuItemGroupD = new JMenuItem("Gruppe D");
        menuItemGroupE = new JMenuItem("Gruppe E");
        menuItemGroupF = new JMenuItem("Gruppe F");
        menuItemGroupG = new JMenuItem("Gruppe G");
        menuItemGroupH = new JMenuItem("Gruppe H");
        menuItemGroupI = new JMenuItem("Gruppe I");
        menuItemGroupJ = new JMenuItem("Gruppe J");
        menuItemGroupK = new JMenuItem("Gruppe K");
        menuItemGroupL = new JMenuItem("Gruppe L");
        //Viertes Menü
        menuItemTimeTableGroup = new JMenuItem("Gruppenphase");
        menuItemTimeTable16 = new JMenuItem("Sechsehntelfinale");
        menuItemTimeTable8 = new JMenuItem("Achtelfinale");
        menuItemTimeTable4 = new JMenuItem("Viertelfinale");
        menuItemTimeTable2 = new JMenuItem("Halbinale");
        menuItemTimeTableFinale = new JMenuItem("Finale");

        // Menüeinträge dem Menü hinzufügen
        menu.add(menuItem3);
        menu.add(menuItem);
        menu.add(menuItem2);
        //zweites Menü
        poolmenu.add(menuItemTeamadd);
        poolmenu.add(menuItemTeamremove);
        poolmenu.add(menuItemAllTeamsView);
        poolmenu.add(menuItemAllTeamsRemove);
        //drittes Menü
        groups.add(menuItemGroupA);
        groups.add(menuItemGroupB);
        groups.add(menuItemGroupC);
        groups.add(menuItemGroupD);
        groups.add(menuItemGroupE);
        groups.add(menuItemGroupF);
        groups.add(menuItemGroupG);
        groups.add(menuItemGroupH);
        groups.add(menuItemGroupI);
        groups.add(menuItemGroupJ);
        groups.add(menuItemGroupK);
        groups.add(menuItemGroupL);
        //Viertes Menü
        timetable.add(menuItemTimeTableGroup);
        timetable.add(menuItemTimeTable16);
        timetable.add(menuItemTimeTable8);
        timetable.add(menuItemTimeTable4);
        timetable.add(menuItemTimeTable2);
        timetable.add(menuItemTimeTableFinale);
        
        //Menüpunkte laden, speichern und beenden mit Funktionen versehen
        menuItem.addActionListener(e -> System.exit(0));
        menuItem2.addActionListener(e -> System.exit(0));//später anpassen
        menuItem3.addActionListener(e -> System.exit(0));//später anpassen
        //Zweites Menü für Team-Pool
        menuItemTeamadd.addActionListener(e -> getInput());
        menuItemTeamremove.addActionListener(e -> deleteOneTeamFromDB());//später anpassen hier das entfernen der Teams
        menuItemAllTeamsView.addActionListener(e -> getTeamsToView());
        menuItemAllTeamsRemove.addActionListener(e -> deleteAllTeamsFromDB());//später anpassen hier das entfernen aller Teams

        //Drittes Menü für Gruppen
        menuItemGroupA.addActionListener(e -> {
            // Neues Child-Window (Dialog) erstellen
            JDialog groupADialog = new JDialog(frame, "Gruppe A", true);
            groupADialog.setSize(400, 300);
            groupADialog.setLocationRelativeTo(frame);
            groupADialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
          
            Container contentPane = groupADialog.getContentPane();
             SpringLayout layout = new SpringLayout();
            contentPane.setLayout(layout);



            //groupADialog.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));

            // Beispielinhalt für das Child-Window
            JLabel labelGroupA = new JLabel("Wählen Sie die Mannschaften für diese Gruppe aus:");
            labelGroupA.setHorizontalAlignment(SwingConstants.CENTER);
            contentPane.add(labelGroupA);
            
            //Ruft eine Schleife für die erstellung der Checkboxen auf
            String teams_check = getTeamsToGroup();
            String[] teamsArray = teams_check.split("\n");
            for (String team : teamsArray) {
                JCheckBox teambox = new JCheckBox(team);
              
                      contentPane.add(teambox);

               
            }
                // JCheckBox checkBox = new JCheckBox(team);
                // groupADialog.add(checkBox);
            
                

            JButton okButton = new JButton("speichern");
            JButton cancelButton = new JButton("Abbrechen");
            okButton.setPreferredSize(new Dimension(100, 42));
            cancelButton.setPreferredSize(new Dimension(100, 42));
            okButton.addActionListener(e1 -> System.out.println("OK Button clicked"));
            cancelButton.addActionListener(e1 -> groupADialog.dispose());
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);

            layout.putConstraint(SpringLayout.SOUTH, okButton,
                     5,
                     SpringLayout.SOUTH, cancelButton);  
                     

            contentPane.add(buttonPanel);
            contentPane.setVisible(true);
            //contentPane.pack();
            groupADialog.pack();
        //    groupADialog.add(listPane);
            groupADialog.setVisible(true);
        });

        //Menüs der Menüleiste hinzufügen
        menuBar.add(menu);
        menuBar.add(poolmenu);
        menuBar.add(groups);
        menuBar.add(timetable);
        //Das Fenster wird in der Mitte des Bildschirms angezeigt
        textArea = new JTextArea(20,50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        //frame.setBounds(150,150,900, 600);
        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        // Menüleiste zum Fenster hinzufügen
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null); // Zentriert auf dem Bildschirm
    }

    public void displayMessage(String message) {
        textArea.append(message + "\n");
    }

    //Wird aufgefrufen, wenn kein Datenbankeintrag gefunden wurde
    public static void displayErrorMessage(){
        JOptionPane.showMessageDialog(null, "Team nicht gefunden!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    //Team ist schon vorhanden
    public static void displayTeamAlreadyExistsMessage(){
        JOptionPane.showMessageDialog(null, "Team ist bereits vorhanden!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    //Bestätigungsdialog für das Hinzufügen eines Teams
    public static void displayOKMessage(){
        JOptionPane.showMessageDialog(null, "Team erfolgreich hinzugefügt!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    //Bestätigungsdialog für das Löschen eines Teams
    public static void displayDeleteOKMessage(){
        JOptionPane.showMessageDialog(null, "Team erfolgreich gelöscht!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }   

    // Methode zum Löschen des Textfelds
    public void clearTextArea() {
        textArea.setText("");
    }

    //Eingabefeld für neues Team zum Eintragen in die Datenbank
    public void getInput() {
        //Eingabeaufforderung für den Namen des neuen Teams und Errormessage
        String inputNewTeam = JOptionPane.showInputDialog("Neues Team eingeben:");
        if (inputNewTeam == null || inputNewTeam.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Keine Eingabe gemacht.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Neues datenbank-Objekt und Eingabe wird an Controller weitergeleitet
        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.addTeam(inputNewTeam);
        dbConnector.closeConnection();//Connection schließen
    }

    //Eingabefeld für das Entfernen eines Teams
    //Hier wird das Team aus der DB gelöscht
    public void deleteOneTeamFromDB() {
        //Eingabeaufforderung für den Namen des neuen Teams und Errormessage
        String inputDeleteTeam = JOptionPane.showInputDialog("Welches Team soll gelöscht werden?:");
        if (inputDeleteTeam == null || inputDeleteTeam.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Keine Eingabe gemacht.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Neues datenbank-Objekt und Eingabe wird an Controller weitergeleitet
        DatabaseConnector dbConnector = new DatabaseConnector();
        dbConnector.deleteTeam(inputDeleteTeam);
        dbConnector.closeConnection();//Connection schließen
    }

    //Ruft die Methode auf, um alle Teams aus der DB anzuzeigen
    public void getTeamsToView() {
        DatabaseConnector viewdbConnector = new DatabaseConnector();
        String liste = viewdbConnector.getTeams();
        clearTextArea();
        displayMessage("Dieses Team ist schon vorhanden:");
        displayMessage(liste);
    }

    //Löscht alle Teams aus der DB
    public void deleteAllTeamsFromDB(){
        //Eingabeaufforderung für den Namen des neuen Teams und Errormessage
        int response = JOptionPane.showConfirmDialog(null, "Wirklich alle Teams löschen?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        //Wenn der Benutzer auf "Ja" klickt, werden alle Teams aus der DB gelöscht
        if (response == JOptionPane.YES_OPTION) {
            DatabaseConnector dbConnector = new DatabaseConnector();
            dbConnector.deleteAllTeams();
            dbConnector.closeConnection();
            System.out.println("Verbindung beendet");//Connection schließen
        }
        else if (response == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Es wurde kein Team gelöscht.", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Ruft alle Teams aus Datenbank, die noch keiner Gruppe zugeordnet sind
    public String getTeamsToGroup() {
        DatabaseConnector dbConnector = new DatabaseConnector();
        String liste = dbConnector.getTeamsWithoutGroup();
        return liste;
    }
    
}
