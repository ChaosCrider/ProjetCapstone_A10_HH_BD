package bdeb.oscar.electionService.data;

import bdeb.oscar.electionService.model.Elector;
import bdeb.oscar.electionService.model.Vote;

import java.util.ArrayList;
import java.util.Date;

public class InMemoryVoteRepo {

    private ArrayList<Vote>  votes = null;
    private static InMemoryVoteRepo instance = null;

    /*
     * Creates the fake data for testing purposes.
     */
    private InMemoryVoteRepo() {
        votes = new ArrayList<Vote>();

        votes.add(new Vote("Dad Joke Detectives",7, new Date(), new Elector(10, "ChuckleChase Studios")));
        votes.add(new Vote("Aliens in Pajamas", 5, new Date(), new Elector(10, "Guffaw Galaxy Films")));
        votes.add(new Vote("The Misadventures of Chuckletron 3000",3, new Date(), new Elector(10, "WhimsiWit Productions")));
        votes.add(new Vote("Laughocalypse Now", 2, new Date(), new Elector(10, "JestQuest Entertainment")));
        votes.add(new Vote("Silly Sleuths and the Case of the Missing Punchline",9, new Date(), new Elector(10, "Lighthearted Lunacy Studios")));
        votes.add(new Vote("Zombie Stand-Up Club",12, new Date(), new Elector(10, "GiggleSphere Films")));
        votes.add(new Vote("The Hilarious Handbook of Time Travel Etiquette",32, new Date(), new Elector(10, "QuirkQuotient Productions")));
        votes.add(new Vote("Ticklish Tornadoes",14, new Date(), new Elector(10, "SnickerSync Studios")));
        votes.add(new Vote("Quarantine Chronicles: Life in the Laughter Lane",7, new Date(), new Elector(10, "BellyLaugh Blockbusters")));
        votes.add(new Vote("Space Cats: The Comedy Constellation",10, new Date(), new Elector(10, "Witty Whirlwind Pictures")));

    }

    /*
     * returns the instance and creates it if not already instanced.
     */
    public static InMemoryVoteRepo getInstance ()
    {

        if (instance == null){ instance = new InMemoryVoteRepo(); }
        return instance;
    }


    /*
     * returns a vote by title and elector.
     */
    public Vote FindVodeBytitle(String title, Elector elector){
        for(Vote v : votes)
        {
            if (v.getTitle().equalsIgnoreCase(title) && elector == v.getOwner()){ return v;}
        }
        return null;
    }

    /*
     *
     */
    public ArrayList<Vote> findVotesByElector(Elector elector)
    {
        ArrayList<Vote> resutls = new ArrayList<Vote>();
        for(Vote v : votes)
        {
            if (elector == v.getOwner()){ resutls.add(v);}
        }
        return resutls;
    }

    /*
     * returns the list of all the votes regardless of ownership.
     */
    public ArrayList<Vote> FindAllVotes()
    {
        return votes;
    }



}
