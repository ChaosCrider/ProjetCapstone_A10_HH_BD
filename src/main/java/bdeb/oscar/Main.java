package bdeb.oscar;

import bdeb.oscar.awardService.data.InMemNominationRepo;
import bdeb.oscar.awardService.persistence.InMemNominationDOA;
import bdeb.oscar.electionService.controller.NominateWorkService;
import bdeb.oscar.electionService.data.InMemVoteRepo;
import bdeb.oscar.electionService.model.Elector;
import bdeb.oscar.electionService.persistence.InMemVoteDAO;
import bdeb.oscar.electionService.view.NominateView;

public class Main {
    public static void main(String[] args) {

        NominateView nominateView = new NominateView(new NominateWorkService(new InMemNominationDOA(InMemNominationRepo.getInstance()), new InMemVoteDAO(InMemVoteRepo.getInstance())));
        initializeData(nominateView);

        testDAta(nominateView);


    }

    private static void testDAta(NominateView nominateView) {
        Elector e = new Elector(10, "Bruno");
        nominateView.createNomination(e);
        nominateView.createNomination(e);
        nominateView.listAllNominations();
    }

    private static void initializeData(NominateView nominateView) {
        /**
         * 1. create awards.
         * 2. create elector.
         * 3. create nomination,
         *      which should create votes,
         *      as well as updating award-nomination and award.elector.
         */

        //1

        //2

        //3

        //4

    }


}