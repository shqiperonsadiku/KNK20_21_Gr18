package sample;

public class ModelTable {

    String id, homeTeam, score, guestTeam;

    public ModelTable(String id, String name, String homeTeam, String guestTeam) {
        this.id = id;
        this.homeTeam = name;
        this.score= homeTeam;
        this.guestTeam = guestTeam;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
    }

    public String getGuestTeam() {
        return guestTeam;
    }
    public void setGuestTeam(String guestTeam) {
        this.guestTeam = guestTeam;
    }
}
