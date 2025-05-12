package programfiles.model;

public class Match {
    private int matchID;
    private String matchDate;
    private Team teamHome;
    private Team teamAway;
    private int scoreHome;
    private int scoreAway;
    private Boolean extraTime;
    private Boolean penalty;


    public Match(int matchID, String matchDate, Team teamHome, Team teamAway, int scoreHome, int scoreAway, Boolean extraTime, Boolean penalty) {
        this.matchID = matchID;
        this.matchDate = matchDate;
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        this.extraTime = extraTime;
        this.penalty = penalty;
     }

    public int getMatchID() {
        return matchID;
    }
    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }
    public String getMatchDate() {
        return matchDate;
    }
    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }
    public Team getTeamHome() {
        return teamHome;
    }
    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }
    public Team getTeamAway() {
        return teamAway;
    }
    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
    }
    public int getScoreHome() {
        return scoreHome;
    }
    public void setScoreHome(int scoreHome) {
        this.scoreHome = scoreHome;
    }
    public int getScoreAway() {
        return scoreAway;
    }
    public void setScoreAway(int scoreAway) {
        this.scoreAway = scoreAway;
    }
    public Boolean getExtraTime() {
        return extraTime;
    }
    public void setExtraTime(Boolean extraTime) {
        this.extraTime = extraTime;
    }
    public Boolean getPenalty() {
        return penalty;
    }
    public void setPenalty(Boolean penalty) {
        this.penalty = penalty;
    }
}