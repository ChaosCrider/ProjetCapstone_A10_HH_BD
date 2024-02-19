package bdeb.oscar.awardService.data;

import bdeb.oscar.awardService.model.Nomination;


import java.util.ArrayList;

public class InMemNominationRepo {
    
    private static InMemNominationRepo instance = null;
    private ArrayList<Nomination> Nominations;

    private InMemNominationRepo() { Nominations = new ArrayList<>();}

    public static InMemNominationRepo getInstance() {
        if(instance == null){instance = new InMemNominationRepo();}
        return instance;
    }

    public ArrayList<Nomination> getNominations() {
        return Nominations;
    }

    public void addNomination(Nomination nomination) {
        this.Nominations.add(nomination);
    }
}
