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
        JMenu menu;
        JMenuItem menuItem;
        menuBar = new JMenuBar();
        menu = new JMenu("Datei");
        menuItem = new JMenuItem("speichern");
    
        menuItem = new JMenuItem("beenden");
        menuItem.addActionListener(e -> System.exit(0));
        menu.add(menuItem);
        
        menu.add(menuItem);
        menuBar.add(menu);
        
        //frame.setSize(600, 400);
        //Das Fenster wird in der Mitte des Bildschirms angezeigt
        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        frame.add(scrollPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null); // Center the window
    }

    public void displayMessage(String message) {
        textArea.append(message + "\n");
    }

    public void clearTextArea() {
        textArea.setText("");
    }
}
