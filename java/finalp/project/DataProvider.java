package finalp.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mohammed on 30-Nov-16.
 */
public class DataProvider {
    public static List<Competition> CompList = new ArrayList<>();
    public static Map<String, Competition> CompMap = new HashMap<>();

    static {

        addProduct("en", "Premier League");
        addProduct("sp", "La Liga");
        addProduct("fr", "Ligue 1");
        addProduct("it", "Seria A");
        addProduct("gr", "Bundesliga");
        addProduct("u", "Uefa Champions League");
        addProduct("eu", "Uefa Europa League");
        addProduct("er", "Eredivisie");
        addProduct("eg", "Egyptian League");
        addProduct("sc", "Scottish League");


    }

    private static void addProduct(String CompId, String name) {
        Competition Co = new Competition(CompId, name);
        CompList.add(Co);
        CompMap.put(CompId, Co);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (Competition competition : CompList) {
            list.add(competition.getName());
        }
        return list;
    }

    public static List<Competition> getFilteredList(String searchString) {

        List<Competition> filteredList = new ArrayList<>();
        for (Competition competition : CompList) {
            if (competition.getProductId().contains(searchString)) {
                filteredList.add(competition);
            }
        }

        return filteredList;

    }
}
