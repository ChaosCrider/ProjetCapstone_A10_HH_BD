package bdeb.oscar.awardService.data;


import bdeb.oscar.awardService.model.Award;
import bdeb.oscar.awardService.model.Award;

import java.util.ArrayList;

public class InMemAwardRepo {

    private static InMemAwardRepo instance = null;
    private ArrayList<Award> awards;

    private InMemAwardRepo() { awards = new ArrayList<>();}

    public static InMemAwardRepo getInstance() {
        if(instance == null){instance = new InMemAwardRepo();}
        return instance;
    }


    public ArrayList<Award> getAwards() {
        return awards;
    }

    public void addAward(Award award) {
        this.awards.add(award);
    }
}
