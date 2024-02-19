package bdeb.oscar.electionService.persistence;

import bdeb.oscar.electionService.model.Elector;

import java.util.ArrayList;

public interface IElectorDAO {

    public Elector findByName(String name);

    public ArrayList<Elector> findAll();

    public int createElector();

    public int updateElector();

}
