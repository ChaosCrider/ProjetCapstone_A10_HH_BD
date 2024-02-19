package bdeb.oscar.electionService.data;

import bdeb.oscar.electionService.model.Elector;
import bdeb.oscar.electionService.model.Vote;

import java.util.ArrayList;

public class InMemVoteRepo {

    private ArrayList<Vote>  votes = null;
    private static InMemVoteRepo instance = null;

    /**
     * Creates the fake data for testing purposes.
     */
    private InMemVoteRepo() {
        votes = new ArrayList<Vote>();
    }

    /**
     * returns the instance and creates it if not already instanced.
     */
    public static InMemVoteRepo getInstance ()
    {

        if (instance == null){ instance = new InMemVoteRepo(); }
        return instance;
    }


    /**
     * attempts to add a vote, if not already present, return 1 if added or 0 if dupe found.
     */
    public int addVote(Vote vote)
    {
        if(!votes.contains(vote)){
            votes.add(vote);
            return 1;
        } else {return 0;}
    }

    /**
     * removes an item from the list, assuming it can find it.
     */
    public int removeVote(Vote vote)
    {
        //check for dupe and adds its if not present.
        if(!votes.contains(vote)){
            votes.remove(vote);
            return 1;
        } else {return 0;}
    }

    /**
     *  returns all votes an elector has registered to its name.
     */
    public ArrayList<Vote> findVotesByElector(Elector elector)
    {
        ArrayList<Vote> resutls = new ArrayList<Vote>();
        for(Vote v : votes)
        {
            if (elector == v.getElector()){ resutls.add(v);}
        }
        return resutls;
    }

    /**
     * returns the list of all the votes regardless of ownership.
     */
    public ArrayList<Vote> FindAllVotes()
    {
        return votes;
    }



}
