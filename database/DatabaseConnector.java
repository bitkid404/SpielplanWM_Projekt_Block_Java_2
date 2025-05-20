package database;

import java.sql.*;
import java.util.LinkedList;
import java.util.ArrayList;
import programfiles.model.Team;
import programfiles.view.View;
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
			String db = "jdbc:sqlite:database/wmplandatabase.db";
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

		//Fügt ein neues Team zur Datenbank hinzu
		public void addTeam(String inputNew){
			try{
				//Überprüfen, ob das Team bereits existiert
				String check = "SELECT * FROM Teams WHERE team_name = ?";
				PreparedStatement pstmtCheck = con.prepareStatement(check);
				pstmtCheck.setString(1, inputNew);
				ResultSet rs = pstmtCheck.executeQuery();
				if(rs.next()){
					System.out.println("Team existiert bereits!");
					rs.close();
					pstmtCheck.close();
					View.displayTeamAlreadyExistsMessage();
					return;
				}
				//Belegt den Datensatz mit den Standardwerten
				// und fügt das Team zur Datenbank hinzu
				String sql = "INSERT INTO Teams (team_name, goals_total, goals_against_total, points) VALUES (?, 0, 0, 0)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, inputNew);
				pstmt.executeUpdate();
				pstmt.close();
				View.displayOKMessage();
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
				ResultSet rs = stmt.executeQuery("SELECT team_name, wm_group FROM Teams");
				while(rs.next()){
					String teamName = rs.getString("team_name");
					String group = rs.getString("wm_group");
					if(group == null){
						group = "keine Gruppe";
					}
					teams.add(teamName + "  -  " + group);
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

		//Nur ein Team löschen
		public void deleteTeam(String inputDeleteTeam){
			try{
				//Überprüfen, ob das Team existiert
				String check = "SELECT * FROM Teams WHERE team_name = ?";
				PreparedStatement pstmtCheck = con.prepareStatement(check);
				pstmtCheck.setString(1, inputDeleteTeam);
				ResultSet rs = pstmtCheck.executeQuery();
				if(!rs.next()){
					System.out.println("Team nicht gefunden!");
					rs.close();
					pstmtCheck.close();
					View.displayErrorMessage();
					return;
				}
				//Wenn das Team existiert, löschen und Bestätigungsdialog anzeigen
				String sql = "DELETE FROM Teams WHERE team_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, inputDeleteTeam);
				pstmt.executeUpdate();
				pstmt.close();
				rs.close();
				pstmtCheck.close();
				View.displayDeleteOKMessage();
				System.out.println("Team erfolgreich gelöscht!");
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Löschen des Teams aus der Datenbank!");
			}
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

		//Ruft alle Teams aus Datenbank, die noch in keiner Gruppe sind
		public String getTeamsWithoutGroup(){
			ArrayList<String> teams = new ArrayList<String>();
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT team_name FROM Teams WHERE wm_group IS NULL");
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

		//Ruft alle Teams aus Datenbank, die in einer bestimmten Gruppe sind
		public String getTeamsInGroup(String inputGroup){
			ArrayList<String> teams = new ArrayList<String>();
			try{
				String sql = "SELECT team_name, goals_total, goals_against_total, points FROM Teams WHERE wm_group = ? ORDER BY points DESC, (goals_total - goals_against_total) DESC";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, inputGroup);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					String teamName = rs.getString("team_name");
					Integer totalGoals = rs.getInt("goals_total");
					Integer totalGoalsAgainst = rs.getInt("goals_against_total");
					Integer totalPoints = rs.getInt("points");
					teams.add(String.format("%-30s  Tore: %2d : %-2d   Punkte: %2d", teamName, totalGoals, totalGoalsAgainst, totalPoints));
				}
				rs.close();
				pstmt.close();
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


		//Kompletten Vorrundenspielplan aus Datenbank holen
		public String getAllGroupMatches(){
			ArrayList<String> matches = new ArrayList<String>();
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Matchs");
				while(rs.next()){
					String matchID = rs.getString("match_id");
					String team1 = rs.getString("team_home");
					String team2 = rs.getString("team_away");
					String date = rs.getString("day");
					matches.add(matchID + ": " + team1 + " vs. " + team2 + " am " + date);
				}
				rs.close();
				stmt.close();
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Abrufen der Spiele aus der Datenbank!");
			}
			String groupMatchList = "";
			for(String match : matches){
				groupMatchList += match + "\n";
			}
			return groupMatchList;
		}

		//Team zur Gruppe hinzufügen
		public void addTeamToGroupDB(String inputTeam, String inputGroup){
			try{
				//Überprüfen, ob das Team existiert
				String check = "SELECT * FROM Teams WHERE team_name = ?";
				PreparedStatement pstmtCheck = con.prepareStatement(check);
				pstmtCheck.setString(1, inputTeam);
				ResultSet rs = pstmtCheck.executeQuery();
				if(!rs.next()){
					System.out.println("Team nicht gefunden!");
					rs.close();
					pstmtCheck.close();
					View.displayErrorMessage();
					return;
				}
				//Überprüfen, ob schon maximal vier Teams in der Gruppe sind
				String checkGroup = "SELECT * FROM Teams WHERE wm_group = ?";
				PreparedStatement pstmtCheckGroup = con.prepareStatement(checkGroup);
				pstmtCheckGroup.setString(1, inputGroup);
				ResultSet rsGroup = pstmtCheckGroup.executeQuery();
				int count = 0;
				while(rsGroup.next()){
					count++;
				}
				if(count >= 4){
					System.out.println("Gruppe ist bereits voll!");
					rsGroup.close();
					pstmtCheckGroup.close();
					View.displayGroupFullMessage();
					return;
				}
				//Wenn das Team existiert, Gruppe zuweisen
				String sql = "UPDATE Teams SET wm_group = ? WHERE team_name = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, inputGroup);
				pstmt.setString(2, inputTeam);
				pstmt.executeUpdate();
				pstmt.close();
				rs.close();
				pstmtCheck.close();
				View.displayOKMessage();
			} catch(SQLException e){
				System.err.println(e.getMessage());
				System.out.println("Fehler beim Hinzufügen des Teams zur Gruppe!");
			}
		}
}