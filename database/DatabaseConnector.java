package database;

import java.sql.*;
import java.util.LinkedList;
import java.util.ArrayList;
import programfiles.model.Team;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;

public class DatabaseConnector {

	private Connection con;
	

	public DatabaseConnector(){
		try{
			Class.forName("org.sqlite.JDBC");
			String db = "jdbc:sqlite:C:/Users/rgrik/Desktop/script-folder/Spielplan_Projekt_JavaII/SpielplanWM_Projekt_Block_Java_2/database/wmplandatabase.db";
			this.con = DriverManager.getConnection(db);
			System.out.println("Verbindung zur Datenbank hergestellt!");

		}

		catch(ClassNotFoundException e){
			System.out.println("Datenbanktreiber nicht gefunden!");
		}

		catch(SQLException e){
			System.out.println("Fehler bei der Verbindung zur Datenbank!");
		}
		
		catch(Exception e){
			System.err.println(e.getMessage());

		}


	}
		public void closeConnection(){
			try{
				if(con != null){
					con.close();
					System.out.println("Verbindung zur Datenbank geschlossen!");
				}
			} catch(SQLException e){
				System.err.println(e.getMessage());
			}
		}

		//Holt alle Teams aus der Datenbank
		// und gibt sie als Array zurück
		public Team[] getAllTeams(){
			Team[] teams = null;
			LinkedList<Team> teamlist = new LinkedList<Team>();
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Teams");
				while(rs.next()){
					int teamID = rs.getInt("team_id");
					String teamName = rs.getString("team_name");
					Integer totalGoals = rs.getInt("goals_total");
					Integer totalGoalsAgainst = rs.getInt("goals_against_total");
					Integer totalPoints = rs.getInt("points");
					String group = rs.getString("wm_group");

					Team team = new Team(teamID, teamName, totalGoals, totalGoalsAgainst, totalPoints, group);
					teamlist.add(team);
				}

				teams = teamlist.toArray(new Team[0]);
				rs.close();
				stmt.close();
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Abrufen der Teams aus der Datenbank!");
			}
			return teams;
		}

		public void addTeam(String inputNew){
			try{
				String sql = "INSERT INTO Teams (team_name) VALUES (?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, inputNew);
				pstmt.executeUpdate();
				pstmt.close();
				System.out.println("Team erfolgreich hinzugefügt!");
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Hinzufügen des Teams zur Datenbank!");
			}
		}

		//Teamliste dem View zur Übersicht übergeben
		public String getTeams(){
			ArrayList<String> teams = new ArrayList<String>();
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT team_name FROM Teams");
				while(rs.next()){
					String teamName = rs.getString("team_name");
					teams.add(teamName);
				}
				rs.close();
				stmt.close();
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Abrufen der Teams aus der Datenbank!");
			}
			String teamList = "";
			for(String team : teams){
				teamList += team + "\n";
			}
			return teamList;
		}

		//Alle Teams aus der Datenbank löschen
		public void deleteAllTeams(){
			try{
				Statement stmt = con.createStatement();
				stmt.executeUpdate("DELETE FROM Teams");
				stmt.close();
				System.out.println("Alle Teams erfolgreich gelöscht!");
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Löschen der Teams aus der Datenbank!");
			}
		}
}