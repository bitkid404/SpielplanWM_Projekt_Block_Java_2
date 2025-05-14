package programfiles.model;

public class Team {
    private int teamID;
    private String teamName;
    private Integer totalGoals;
    private Integer totalGoalsAgainst;
    private Integer totalPoints;
    private String group;

    public Team(int teamID, String teamName, Integer totalGoals, Integer totalGoalsAgainst, Integer totalPoints, String group ) {
        this.teamID = teamID;
        this.teamName = teamName;
        this.totalGoals = totalGoals;
        this.totalGoalsAgainst = totalGoalsAgainst; 
        this.totalPoints = totalPoints;
        this.group = group;
        }
    
        public int getTeamID() {
            return teamID;
        }
    
        public void setTeamID(int teamID) {
            this.teamID = teamID;
        }
    
        public String getTeamName() {
            return teamName;
        }
    
        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public Integer getTotalGoals() {
            return totalGoals;
        }

        public void setTotalGoals(Integer totalGoals) {
            this.totalGoals = totalGoals;
        }

        public Integer getTotalGoalsAgainst() {
            return totalGoalsAgainst;
        }

        public void setTotalGoalsAgainst(Integer totalGoalsAgainst) {
            this.totalGoalsAgainst = totalGoalsAgainst;
        }

        public Integer getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(Integer totalPoints) {
            this.totalPoints = totalPoints;
        }   

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }
    }

