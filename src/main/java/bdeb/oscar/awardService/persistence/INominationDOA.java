package bdeb.oscar.awardService.persistence;

import bdeb.oscar.awardService.model.Nomination;

import java.util.ArrayList;

public interface INominationDOA {

    public Nomination findByWork(String work);

    public ArrayList<Nomination>  findAll();

    public int createNomination(Nomination nomination);

    public int updateNomination(Nomination nomination);

}
