package bdeb.oscar.electionService.model;

import bdeb.oscar.awardService.model.Award;

import java.util.ArrayList;

public class Elector {

    /*
    *
    *   weight: Relating to the voting value.
    *   name: Name of the Organization.
    *   awards: List of [TBD] for the Organization.
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

    //finds an award by its location in the list
    public Award findAwardByPos(int pos)
    {
        return new Award();
    }

    //finds an award by its name attribute.
    public Award findAwardByName(String name)
    {
        return new Award();
    }

    @Override
    public String toString() {
        return "Elector{" +
                "weigth=" + weight +
                ", name=" + name +
                '}';
    }
}
