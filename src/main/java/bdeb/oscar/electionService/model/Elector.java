package bdeb.oscar.electionService.model;

import bdeb.oscar.awardService.model.Award;

import java.util.ArrayList;

public class Elector {

    /*
     *
     *   weight: Relating to the voting value.
     *   name: Name of the Organization.
     *   awards: List of award categories for the Organization to nominate movies and people for.
     *
     */
    private int weight;//the full voting potential
    private int availableVotes;//the voting amount left to consume.
    private String name;
    ArrayList<Award> awards;

    public Elector(int weight, String name) {
        this.weight = weight;
        this.availableVotes = weight;
        this.name = name;
        this.awards = new ArrayList<>(); //needs to get it from the DAO
    }

    public void spendShares(int amount) {
        availableVotes -= amount;
    }

    public int getWeigth() {
        return weight;
    }

    public void setWeigth(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableVotes() {
        return availableVotes;
    }

    public void resetVotes() {
        //Removes all existing votes from this elector, then reset the votes available.
        //Call Calls DAO to purge votes from persistance.
        //this.availableVotes = weight;
    }

    @Override
    public String toString() {
        return "Elector{" +
                "weigth=" + weight +
                ", name=" + name +
                '}';
    }

    public void consumeVotes(int shares) {
        this.availableVotes -= shares;
    }

    public void refundVotes(int obtainedShares) {
    }
}
