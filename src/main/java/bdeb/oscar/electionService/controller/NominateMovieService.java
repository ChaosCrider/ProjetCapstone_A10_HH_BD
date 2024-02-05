package bdeb.oscar.electionService.controller;

import bdeb.oscar.awardService.model.Nomination;
import bdeb.oscar.electionService.model.Elector;

import java.util.List;

public class NominateMovieService {

    List<Nomination> nominationList;

    public void nominateMovie(String nominatedWork, int year, Elector voter, int awardType, int shares)
    {
        Nomination nominee = null;

        for(Nomination n : nominationList)
        {
            if (n.getNominatedWork().equals(nominatedWork))
            {
                nominee = n;
                break;
            }
        }

        if(nominee != null)//if it already exists
            {
                nominee.setShares(nominee.getShares()+shares);
            }//
        else
        {
            nominationList.add(new Nomination());
        }
    }

}
