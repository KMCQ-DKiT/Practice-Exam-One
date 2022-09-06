package DAOs;

import DTOs.Football;
import Exception.DaoException;
import java.util.List;

public interface FootballDaoInterface {
    public List<Football> findAllFootballResults() throws DaoException;
    public Football findResultByTeam(String team) throws DaoException;



}
