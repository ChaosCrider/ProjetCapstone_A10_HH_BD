package bdeb.oscar.awardService.persistence;

import bdeb.oscar.awardService.model.Award;

import java.util.ArrayList;

public interface IAwardDOA {

    public Award findByName(String name);

    public ArrayList<Award> findAll();

    public int createAward();

    public int updateAward();
    
}
