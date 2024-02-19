package bdeb.oscar.awardService.model;

public class NominationAward {

    private String work, award;

    public NominationAward(String work, String award) {
        this.work = work;
        this.award = award;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "NominationAward{ work: '" + work + "' , award: '" + award + "'}";
    }
}
