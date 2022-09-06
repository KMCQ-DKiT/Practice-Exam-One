package DTOs;

import java.util.Objects;

public class Football {
    String TeamOne;
    String TeamTwo;
    int TeamOneScore;
    int TeamTwoScore;

    public Football(String TeamOne, String TeamTwo, int TeamOneScore, int TeamTwoScore) {
        this.TeamOne = TeamOne;
        this.TeamTwo = TeamTwo;
        this.TeamOneScore = TeamOneScore;
        this.TeamTwoScore = TeamTwoScore;
    }

    public String getTeamOne() {
        return TeamOne;
    }
    public void setTeamOne(String teamOne) {
        TeamOne = teamOne;
    }
    public String getTeamTwo() {
        return TeamTwo;
    }
    public void setTeamTwo(String teamTwo) {
        TeamTwo = teamTwo;
    }
    public int getTeamOneScore() {
        return TeamOneScore;
    }
    public void setTeamOneScore(int teamOneScore) {
        TeamOneScore = teamOneScore;
    }
    public int getTeamTwoScore() {
        return TeamTwoScore;
    }
    public void setTeamTwoScore(int teamTwoScore) {
        TeamTwoScore = teamTwoScore;
    }

    @Override
    public String toString() {
        return "Football{" +
                "TeamOne='" + TeamOne + '\'' +
                ", TeamTwo='" + TeamTwo + '\'' +
                ", TeamOneScore=" + TeamOneScore +
                ", TeamTwoScore=" + TeamTwoScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Football football)) return false;
        return TeamOneScore == football.TeamOneScore && TeamTwoScore == football.TeamTwoScore && Objects.equals(TeamOne, football.TeamOne) && Objects.equals(TeamTwo, football.TeamTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TeamOne, TeamTwo, TeamOneScore, TeamTwoScore);
    }
}
