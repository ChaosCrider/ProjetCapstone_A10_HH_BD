package bdeb.oscar.electionService.model;

import java.util.Date;

public class Vote {

    /*
    *
    *   shares: number of count(from the weight) consumed by the voter on this one vote.
    *   execution: Date of creation/voting.
    *   owner: the proprietor of this specific vote.
    *
    */
    private int shares;
    private Date execution;
    private Elector owner;
    private String title;

    public Vote(String nomination, int shares, Date execution, Elector owner) {
        this.shares = shares;
        this.execution = execution;
        this.owner = owner;
    }

    public Vote(String nomination, int shares, Elector owner) {
        this.shares = shares;
        this.execution = new Date();
        this.owner = owner;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public Date getExecution() {
        return execution;
    }

    public void setExecution(Date execution) {
        this.execution = execution;
    }

    public Elector getOwner() {
        return owner;
    }

    public void setOwner(Elector owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "shares=" + shares +
                ", execution=" + execution +
                ", owner=" + owner +
                '}';
    }
}
