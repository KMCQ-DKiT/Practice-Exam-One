package Main;

import DAOs.FootballDaoInterface;
import DAOs.MySqlFootballDao;
import DTOs.Football;
import Exception.DaoException;

import java.util.*;

public class MainApp
{
    public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);

        FootballDaoInterface IUserDao = new MySqlFootballDao();
        try {
            System.out.println("\nCall findAllFootballResults()");
            List<Football> footballList = IUserDao.findAllFootballResults();

            if (footballList.isEmpty())
                System.out.println("There are no results");
            else {
                for (Football p : footballList)
                    System.out.println("Football: " + p.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
        Map<String, Football> hash = new HashMap();
        hashMap(hash);
        System.out.println("please enter your key");

        String key = keyboard.nextLine();
        Football products = hash.get(key.toLowerCase(Locale.ROOT));
        System.out.println(key + "FootballResults Hashed= " + products);



            Scanner k = new Scanner(System.in);
            try {
                System.out.println("\nCall: findPlayerByID()");
                System.out.println("Enter ID You Wish To Find: ");
                String team = k.nextLine();
                Football football = IUserDao.findResultByTeam(team);

                if (football != null)
                    System.out.println("Player found: " + football);
                else
                    System.out.println("Player with that ID not found");

            } catch (DaoException e) {
                e.printStackTrace();
            }


    }
    public static void hashMap(Map hash) {
        String key = "liverpool";
        Football football = new Football("ManUtd","Liverpool",2,5);
        hash.put(key, football);

        String key2 = "mancity";
        football = new Football("Tottenham","ManCity",5,2);
        hash.put(key2, football);

        String key3 = "wolves";
        football = new Football("Stoke","Wolves",2,0);
        hash.put(key3, football);

        String key4 = "westham";
        football = new Football("Chelsea","WestHam",1,1);
        hash.put(key4, football);
    }

}

