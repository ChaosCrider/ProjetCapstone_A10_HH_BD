package bdeb.oscar.awardService.persistence;

import bdeb.oscar.awardService.model.Nomination;
import bdeb.oscar.awardService.data.InMemNominationRepo;

import java.util.ArrayList;

public class InMemNominationDOA implements INominationDOA {

    private InMemNominationRepo nominations;

    public InMemNominationDOA(InMemNominationRepo repo) {
        this.nominations = repo;

    }

    @Override
    public Nomination findByWork(String work) {
        Nomination hit = null;
        for(Nomination n : nominations.getNominations())
        {
            if (n.getNominatedWork().equalsIgnoreCase(work)){
                hit = n;
                break;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Nomination> findAll() {
        return nominations.getNominations();
    }

    public int createNomination(Nomination nomination) {
        Boolean hit = false;
        for(Nomination n : nominations.getNominations())
        {
            if (n.getNominatedWork().equalsIgnoreCase(nomination.getNominatedWork())){
                hit = true;
                return 0;
            }
        }
        nominations.addNomination(nomination);
        return 1;
    }

    @Override
    public int updateNomination(Nomination nomination) {
        Boolean hit = false;
        for(Nomination n : nominations.getNominations())
        {
            if (n.getNominatedWork().equalsIgnoreCase(nomination.getNominatedWork())){
                hit = true;
                n = nomination;
                return 1;
            }
        }
        return 0;
    }
}
