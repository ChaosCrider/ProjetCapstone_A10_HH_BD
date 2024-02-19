package bdeb.oscar.awardService.data;

import bdeb.oscar.awardService.model.NominationAward;

import java.util.ArrayList;

public class InMemNominationAwardRepo {

    private static InMemNominationAwardRepo instance = null;
    private ArrayList<NominationAward> NominationAwards;

    private InMemNominationAwardRepo() { NominationAwards = new ArrayList<>();}

    public static InMemNominationAwardRepo getInstance() {
        if(instance == null){instance = new InMemNominationAwardRepo();}
        return instance;
    }

    public ArrayList<NominationAward> getNominationAwards() {
        return NominationAwards;
    }

    public void addNominationAward(NominationAward NominationAward) {
        this.NominationAwards.add(NominationAward);
    }
    
}
