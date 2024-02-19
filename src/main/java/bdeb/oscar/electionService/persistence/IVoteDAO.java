package bdeb.oscar.electionService.persistence;

import bdeb.oscar.electionService.model.Vote;

import java.util.ArrayList;

public interface IVoteDAO {

    public Vote findByElector(String elector);

    public ArrayList<Vote> findAll();

    public int createVote(Vote vote);

    public int updateVote(Vote vote, int shares);

}
