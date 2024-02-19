package bdeb.oscar.electionService.controller;

import bdeb.oscar.awardService.data.InMemNominationRepo;
import bdeb.oscar.awardService.model.Nomination;
import bdeb.oscar.awardService.persistence.INominationDOA;
import bdeb.oscar.awardService.persistence.InMemNominationDOA;
import bdeb.oscar.electionService.model.Elector;
import bdeb.oscar.electionService.model.Vote;
import bdeb.oscar.electionService.persistence.IVoteDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NominateWorkService {

    List<Nomination> nominationList;
    INominationDOA nominationDAO = null;
    IVoteDAO voteDAO;

    /**
     * default costructor
     */
    public NominateWorkService(INominationDOA nomDAO, IVoteDAO voteDAO) {
        this.nominationList = new ArrayList<>();
        this.nominationDAO = nomDAO;
        this.voteDAO = voteDAO;
    }

    /**
     * constructor intended for a reset of the nomination table.
     */
    public NominateWorkService(List<Nomination> nominationList) {
        this.nominationList = nominationList;
        if (nominationDAO == null) {
            nominationDAO = new InMemNominationDOA(InMemNominationRepo.getInstance());
        }
    }

    /**
     * Allow the creation of a new nomination (Paired elector/work)
     * adds nomination to nominationList, checks for an already existing to prevent dupes
     * offers to upvote if pre-existing and returns the answer as a Boolean.
     *
     * @param nomination Nomination
     */
    public Boolean nominateMovie(Nomination nomination) {
        reSyncList();
        Nomination nominee = null;

        //scans for matching work
        for (Nomination n : nominationList) {
            if (n.getNominatedWork().equals(nomination.getNominatedWork())) {
                nominee = n;
                break;
            }
        }

        if (nominee != null)    //if it already exists
        {
            Scanner sc = new Scanner(System.in);
            //asks confirmation before upvote
            System.out.println(nominee.getNominatedWork() + " already exists. would you like to upvote? Y/N");
            return false;
        } else {      //if it doesn't
            System.out.println(nominationDAO.createNomination(nomination) + " nomination(s) added succesfully.");
            return true;
        }
    }

    /**
     * Lists all nominations to the console.
     */
    public void viewNominations() {
        reSyncList();
        for (Nomination n : nominationList) {
            System.out.println(n);
        }
    }

    /**
     * Updates the nominationList attribute to ensure it matches the persistence.
     */
    private void reSyncList() {
        nominationList = nominationDAO.findAll();
    }

    /**
     * Passes a Vote to the DAO for registration, returns the created vote.
     * returns null if the persistence fails to add vote
     *
     * @param vote Vote
     * @return Vote or null
     */
    public Vote registerVote(Vote vote) {
        if (voteDAO.createVote(vote) == 1) {
            return vote;
        }
        return null;
    }

    public void Upvote(Vote vote, int shares) {
        voteDAO.updateVote(vote, shares);
    }

    public Nomination findNomination(String work) {
        Nomination n = nominationDAO.findByWork(work);
        return n;
    }

    public boolean findDuplicateNomination(Nomination n, Elector e, NominateWorkService nomService) {
        if (!nomService.nominateMovie(n)) {

            //captures the input to checks if the user wants to upvote
            Scanner sc = new Scanner(System.in);
            boolean check = sc.nextLine().toLowerCase().startsWith("y");
            if (check) {
                return true;
            }
        }
        return false;
    }

    public boolean findDuplicateVote(Nomination n, Vote electorVote, Elector e) {
        //finds nomination and then all the votes it has

        //verify if the elector already has a vote, if he does, offer to increase the number of shares it has
        // if it doesn't, create the adds the newly created vote to the persistence
        for (Vote v : n.getVotes()) {
            if (v.getElector() == e) {
                electorVote = v;
                break;
            }
        }
        if (electorVote != null)
            {return true;}
        return false;
    }
}
