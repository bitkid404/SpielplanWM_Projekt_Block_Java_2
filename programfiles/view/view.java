package programfiles.view;

import javax.swing.*;

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
        
        //Menüpunkte mit Funktionen versehen
        menuItem.addActionListener(e -> System.exit(0));
        menuItem2.addActionListener(e -> System.exit(0));//später anpassen
        menuItem3.addActionListener(e -> System.exit(0));//später anpassen
        //Zweites Menü
        menuItemTeamadd.addActionListener(e -> System.exit(0));//später anpassen
        menuItemTeamremove.addActionListener(e -> System.exit(0));//später anpassen
        //Menüs der Menüleiste hinzufügen
        menuBar.add(menu);
        menuBar.add(poolmenu);
        menuBar.add(groups);
        menuBar.add(timetable);
        
        //frame.setSize(600, 400);
        //Das Fenster wird in der Mitte des Bildschirms angezeigt
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
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

    public void clearTextArea() {
        textArea.setText("");
    }
}
