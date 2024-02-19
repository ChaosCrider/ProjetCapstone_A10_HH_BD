package bdeb.oscar.electionService.view;

import bdeb.oscar.awardService.model.Nomination;
import bdeb.oscar.electionService.controller.NominateWorkService;
import bdeb.oscar.electionService.model.Elector;
import bdeb.oscar.electionService.model.Vote;

import java.util.Scanner;

public class NominateView {

    private NominateWorkService nomService;

    public NominateView(NominateWorkService NomService) {
        this.nomService = NomService;
    }

    /**
     * Request the information for a new nomination, then creates a vote then the nomination using it.
     *
     * @param e Elector
     */
    public void createNomination(Elector e) {
        int availableShares = e.getAvailableVotes();


        //capture data from user input
        Scanner sc = new Scanner(System.in);
        System.out.println("To create a new nomination please provide the following information");

        System.out.println("Name fo the nominated Work:");
        String nominatedWork = sc.nextLine();

        System.out.println("The publishing year of the work");
        int year = sc.nextInt();

        //capture a valid amount of shares.
        int obtainedShares = 0;
        do {
            System.out.println("How many shares to add ?");
            System.out.println("you have " + availableShares + " shares to spend");
            obtainedShares = sc.nextInt();
            if (obtainedShares <= 0 || obtainedShares > availableShares) {
                System.out.println("Amount invalid, must be both lower or equal to the available shares and greater then 0.");
            }
        }
        while (obtainedShares <= 0 || obtainedShares > availableShares);

        //creates a vote for the new nomination
        Vote vote = new Vote(obtainedShares, e);


        if(nomService.findDuplicateNomination(new Nomination(nominatedWork, obtainedShares, year, vote), e, nomService))
        {
            Vote electorVote = null;
            Nomination n = nomService.findNomination(nominatedWork);
            if(nomService.findDuplicateVote(n, electorVote, e))
            {
                nomService.Upvote(electorVote, obtainedShares);
            } else {
                nomService.registerVote(vote);
            }
        } else {e.refundVotes(obtainedShares);}
    }

        //checks if a nomination with this work title already exists
        // if nominatemovies returns true, offers an upvote, if it reutns false then the nomination has been created




    public void listAllNominations() {
        nomService.viewNominations();
    }
}
