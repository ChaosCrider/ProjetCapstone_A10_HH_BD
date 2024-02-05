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
    private int weight;
    private String name;
    ArrayList<Award> awards;

    public Elector(int weight, String name) {
        this.weight = weight;
        this.name = name;
        this.awards = new ArrayList<>();
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

    @Override
    public String toString() {
        return "Elector{" +
                "weigth=" + weight +
                ", name=" + name +
                '}';
    }
}
