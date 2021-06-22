package sample;

public class LaLigaTable {

    String position, teamName, played, wins, draws, losses, goalsFor, goalsAgainst, goalsDifference, points;

    public LaLigaTable(String position, String teamName, String played, String wins, String draws, String losses, String goalsFor, String goalsAgainst, String goalsDifference, String points) {
        this.position = position;
        this.teamName = teamName;
        this.played = played;
        this.wins= wins;
        this.draws = draws;
        this.losses = losses;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
        this.goalsDifference = goalsDifference;
        this.points = points;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getPlayed() {
        return played;
    }
    public void setPlayed(String played) {
        this.played = played;
    }

    public String getWins() {
        return wins;
    }
    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }
    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }
    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getGoalsFor() {
        return goalsFor;
    }
    public void setGoalsFor(String goalsFor) {
        this.goalsFor = goalsFor;
    }

    public String getGoalsAgainst() {
        return goalsAgainst;
    }
    public void setGoalsAgainst(String goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public String getGoalsDifference() {
        return goalsDifference;
    }
    public void setGoalsDifference(String goalsDifference) {
        this.goalsDifference = goalsDifference;
    }

    public String getPoints() {
        return points;
    }
    public void setPoints(String points) {
        this.points = points;
    }


}
