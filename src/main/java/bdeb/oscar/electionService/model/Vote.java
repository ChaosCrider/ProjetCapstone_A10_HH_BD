package bdeb.oscar.electionService.model;

import bdeb.oscar.awardService.model.Award;

import java.util.Date;

public class Vote {

    /*
     *
     *   shares: number of count(from the weight) consumed by the voter on this one vote.
     *   execution: Date of creation/voting.
     *   owner: the proprietor of this specific vote.
     *
     */
    private Award award;
    private int shares;
    private Date execution;
    private Elector elector;


    public Vote(Award award, int shares, Date execution, Elector elector) {
        this.award = award;
        this.shares = shares;
        this.execution = execution;
        this.elector = elector;
    }

    public Vote(int shares, Elector elector) {
        this.shares = shares;
        this.execution = new Date();
        this.elector = elector;
        elector.consumeVotes(shares);
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

    public Elector getElector() {
        return elector;
    }

    public void setElector(Elector elector) {
        this.elector = elector;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "shares=" + shares +
                ", execution=" + execution +
                ", owner=" + elector +
                '}';
    }
}
