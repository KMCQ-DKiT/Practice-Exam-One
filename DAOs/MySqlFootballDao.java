package DAOs;

import DTOs.Football;
import Exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlFootballDao extends MySqlDao implements FootballDaoInterface{


    @Override
    public List<Football> findAllFootballResults() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Football> footballList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM RESULTS";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                String TeamOne = resultSet.getString("homeTeam");
                String TeamTwo = resultSet.getString("awayTeam");
                int TeamOneScore = resultSet.getInt("homeTeamGoals");
                int TeamTwoScore = resultSet.getInt("awayTeamGoals");
                Football u = new Football(TeamOne,TeamTwo, TeamOneScore, TeamTwoScore);
                footballList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllFootballResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllFootballResultSet() " + e.getMessage());
            }
        }
        return footballList;
    }

    @Override
    public Football findResultByTeam(String team) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Football football = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM results WHERE homeTeam OR awayTeam = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, team);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                String TeamOne = resultSet.getString("homeTeam");
                String TeamTwo = resultSet.getString("awayTeam");
                int TeamOneScore = resultSet.getInt("homeTeamGoals");
                int TeamTwoScore = resultSet.getInt("awayTeamGoals");


                football = new Football(TeamOne,TeamTwo, TeamOneScore, TeamTwoScore);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findProductsByID() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findProductsByID() " + e.getMessage());
            }
        }
        return football;

    }
}
