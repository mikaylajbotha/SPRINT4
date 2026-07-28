package strategy;

import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 * Search strategy: match by title.
 */
public class SearchByTitle implements SearchStrategy {

    @Override
    public List<Item> search(List<Item> items, String query) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(query)) {
                results.add(item);
            }
        }
        return results;
    }
}
