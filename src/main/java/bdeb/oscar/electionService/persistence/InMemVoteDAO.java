package bdeb.oscar.electionService.persistence;

import bdeb.oscar.electionService.data.InMemVoteRepo;
import bdeb.oscar.electionService.model.Vote;
import java.util.ArrayList;

public class InMemVoteDAO implements IVoteDAO {

    private InMemVoteRepo repo;
    private ArrayList<Vote> votes;


    public InMemVoteDAO(InMemVoteRepo repo) {
        votes = new ArrayList<>();
        this.repo = repo;
    }


    @Override
    public Vote findByElector(String elector) {
        for (Vote v : votes) {
            if (v.getElector().getName().equalsIgnoreCase(elector)) {
                return v;
            }
        }
        return null;
    }


    @Override
    public ArrayList<Vote> findAll() {
        return votes;
    }

    public int createVote(Vote vote) {
        Boolean hit = false;
        for (Vote v : votes) {
            if (v == vote) {
                hit = true;
                return 0;
            }
        }
        repo.addVote(vote);
        return 1;
    }

    @Override
    public int updateVote(Vote vote, int shares) {
        for (Vote v : repo.FindAllVotes()) {
            if (v.equals(vote)) {
                v = vote;
                v.setShares(v.getShares()+shares);
                return 1;
            }
        }
        return 0;
    }
}
