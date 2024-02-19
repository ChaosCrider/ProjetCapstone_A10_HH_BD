package bdeb.oscar.awardService.model;

import bdeb.oscar.electionService.model.Vote;

import java.util.ArrayList;

public class Nomination {

    private int year, obtainedShares;
    private String nominatedWork;

    //list of all the votes this nomination has.
    private ArrayList<Vote> votes;

    // list of Awards the work is nominated for.
    private ArrayList<Award> awards; //get Award for bridge table from DAO


    public Nomination(String nominatedWork, int obtainedShares, int year, Vote vote) {
        this.year = year;
        this.obtainedShares = obtainedShares;
        this.nominatedWork = nominatedWork;
        votes = new ArrayList<Vote>();
        votes.add(vote);
    }

    public void upVote(int amount) {
        obtainedShares += amount;
    }

    public int getShares() {
        return obtainedShares;
    }

    public void setShares(int amount) {
        obtainedShares = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getObtainedShares() {
        return obtainedShares;
    }

    public void setObtainedShares(int obtainedShares) {
        this.obtainedShares = obtainedShares;
    }

    public String getNominatedWork() {
        return nominatedWork;
    }

    public void setNominatedWork(String nominatedWork) {
        this.nominatedWork = nominatedWork;
    }

    public ArrayList<Vote> getVotes() {
        return votes;
    }

    public ArrayList<Award> getAwards() {
        return awards;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Nomination: '").append(nominatedWork);
        sb.append("', year: ").append(year);
        sb.append(", obtainedShares: ").append(obtainedShares);
        return sb.toString();
    }
}
